/*
 * The MIT License
 *
 * Copyright 2019 Vic Cebedo <cebedo.vii@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cebedo.hr.preparation.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class FrequencyQueries {

    private static final List<Integer> RESULT = new ArrayList<>();
    private static final int PARTITION_SIZE = 50;
    private static final Map<Integer, int[]> PARTITIONS = new HashMap<>();

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int data = query.get(1);

            switch (operation) {
                case 1: {
                    insert(data);
                    break;
                }
                case 2: {
                    delete(data);
                    break;
                }
                case 3: {
                    frequencyExists(data);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return RESULT;
    }

    private static void insert(int data) {
        // data = 48 / 100 = 0.48 = [0]
        // data = 999 / 100 = 9.99 = [9]
        // data = 155 / 100 = 1.55 = [1]
        //      = [55]++;
        // 0 = 0-99
        // 1 = 100-199
        // 2 = 200-299...         
        BigDecimal partSize = new BigDecimal(PARTITION_SIZE);
        BigDecimal decimals = new BigDecimal(data).divide(partSize, 1, RoundingMode.HALF_UP);
        int partitionIndex = decimals.intValue();
        int fractional = decimals.subtract(new BigDecimal(partitionIndex)).multiply(partSize).intValue();
        int[] partition = PARTITIONS.get(partitionIndex) == null
                ? new int[PARTITION_SIZE]
                : PARTITIONS.get(partitionIndex);
        partition[fractional]++;
        PARTITIONS.put(data / PARTITION_SIZE, partition);
    }

    private static void delete(int data) {
        int partitionIndex = data / PARTITION_SIZE;
        if (PARTITIONS.get(partitionIndex) == null) {
            return;
        }
        int[] partition = PARTITIONS.get(partitionIndex);
        partition[fractionalPart(data)]--;
        PARTITIONS.put(partitionIndex, partition);
    }

    private static int fractionalPart(int data) {
        BigDecimal partSize = new BigDecimal(PARTITION_SIZE);
        BigDecimal decimals = new BigDecimal(data).divide(partSize, 1, RoundingMode.HALF_UP);
        return decimals.subtract(new BigDecimal(decimals.intValue())).multiply(partSize).intValue();
    }

    private static void frequencyExists(int frequency) {
        int exists = 0;
        for (int[] partition : PARTITIONS.values()) {
            for (int count : partition) {
                if (count == frequency) {
                    exists = 1;
                    break;
                }
            }
        }
        RESULT.add(exists);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> queries = new ArrayList<>();
        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> ans = freqQuery(queries);
    }
}
