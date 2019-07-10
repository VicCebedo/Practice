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
package com.cebedo.hr.preparation.greedy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MinimumAbsoluteDifference {

    private static boolean isDone(int x, int[] done) {
        for (int d : done) {
            if (x == d) {
                return true;
            }
        }
        return false;
    }

    private static void setAllToMax(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
    }

    static int minimumAbsoluteDifference(int[] arr) {

        int minimum = Integer.MAX_VALUE;
        int i = 0;
        int[] doneX = new int[arr.length];
        setAllToMax(doneX);
        int doneXIndex = 0;

        while (i < arr.length) {

            int x = arr[i];
            int j = i + 1;

            // If this x is already done,
            // skip it. 
            if (isDone(x, doneX)) {
                i++;
                continue;
            }

            Map<Integer, Boolean> doneMap = new HashMap<>();

            while (j < arr.length) {

                int y = arr[j];

                // If this y is already done,
                // skip it. 
                if (doneMap.get(y) != null) {
                    j++;
                    continue;
                }

                int diff = x - y;
                int abs = Math.abs(diff);
                if (abs < minimum) {
                    minimum = abs;
                }

                doneMap.put(y, Boolean.TRUE);
                j++;
            }
            doneX[doneXIndex] = x;
            doneXIndex++;
            i++;
        }

        return minimum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int result = minimumAbsoluteDifference(arr);
        scanner.close();
    }

}
