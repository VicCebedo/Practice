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
package com.cebedo.hackerrank.preparation.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MinimumBribes {

    private static final List<Integer> RESULTS = new ArrayList<>();

    static void minimumBribes(int[] q) {

        Map<Integer, Integer> countMap = new HashMap<>();
        int index = 0;
        int totalSwaps = 0;

        while (index < q.length) {
            int now = q[index];
            if (index + 1 == q.length) {

                // If we have reached the end,
                // check if array is ordered.
                // If not, set index to zero and continue,
                boolean reset = false;
                for (int i = 0; i < q.length; i++) {
                    int current = q[i];
                    if (i + 1 < q.length) {
                        int currentNext = q[i + 1];
                        if (current > currentNext) {
                            reset = true;
                            break;
                        }
                    }
                }
                if (reset) {
                    index = 0;
                    continue;
                } else {
                    break;
                }
            }
            int next = q[index + 1];

            // If now is greater than next,
            // then a swap happened.
            if (now > next) {
                Integer count = countMap.get(now);
                int countAfter = count == null ? 1 : count + 1;
                if (countAfter > 2) {
                    RESULTS.add(-1);
                    return;
                }
                countMap.put(now, countAfter);

                // Swap, then reset.
                q[index] = next;
                q[index + 1] = now;
                totalSwaps++;
            }
            index++;
        }

        // Set min bribes.
        RESULTS.add(totalSwaps);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] q = new int[n];
            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }
            minimumBribes(q);
        }
        scanner.close();

        for (Integer count : RESULTS) {
            if (count == -1) {
                System.out.println("Too chaotic");
            } else {
                System.out.println(count);
            }
        }
    }
}
