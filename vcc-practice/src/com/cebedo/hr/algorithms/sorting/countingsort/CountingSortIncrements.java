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
package com.cebedo.hr.algorithms.sorting.countingsort;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class CountingSortIncrements {

    private static void sort(String[] inputs) {
        int[] count = count(inputs);
        increment(count);
        List<String> result = Arrays.stream(count).mapToObj(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(" ", result));
    }

    private static int[] count(String[] inputs) {
        int[] count = new int[100];
        for (String input : inputs) {
            int num = Integer.parseInt(input.split(" ")[0]);
            count[num]++;
        }
        return count;
    }

    private static void increment(int[] count) {
        int current = 0;
        int ahead = current + 1;
        while (ahead < count.length) {
            count[ahead] = count[current] + count[ahead];
            current++;
            ahead++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] inputs = new String[n];
        int i = 0;
        while (i < n) {
            inputs[i] = scanner.nextLine();
            i++;
        }
        sort(inputs);
        scanner.close();
    }

}
