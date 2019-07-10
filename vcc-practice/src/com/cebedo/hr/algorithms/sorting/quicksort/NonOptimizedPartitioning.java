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
package com.cebedo.hr.algorithms.sorting.quicksort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class NonOptimizedPartitioning {

    static int[] quickSort(int[] arr) {

        int pivot = arr[0];

        List<Integer> lessThan = new ArrayList<>();
        List<Integer> greaterThan = new ArrayList<>();
        int equalCount = 0;

        for (int num : arr) {
            if (num == pivot) {
                equalCount++;
            } else if (num < pivot) {
                lessThan.add(num);
            } else {
                greaterThan.add(num);
            }
        }

        int arrIndex = 0;
        for (int lesserNum : lessThan) {
            arr[arrIndex] = lesserNum;
            arrIndex++;
        }

        for (int i = 0; i < equalCount; i++) {
            arr[arrIndex] = pivot;
            arrIndex++;
        }

        for (int greaterNum : greaterThan) {
            arr[arrIndex] = greaterNum;
            arrIndex++;
        }

        return arr;
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
        int[] result = quickSort(arr);
        scanner.close();
    }

}
