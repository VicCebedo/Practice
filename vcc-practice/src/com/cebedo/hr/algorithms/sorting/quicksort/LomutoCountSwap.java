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
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class LomutoCountSwap {

    private static int SWAP_COUNT = 0;

    private static int[] quickSort(int[] arr) {
        // Initial partition.
        int j = 0;
        int i = j - 1;
        int pivot = arr[arr.length - 1];

        while (j < arr.length) {
            int currentValue = arr[j];
            if (currentValue < pivot) {
                i++;
                arr[j] = arr[i];
                arr[i] = currentValue;
                SWAP_COUNT++;
            }
            j++;
        }
        i++;
        arr[arr.length - 1] = arr[i];
        arr[i] = pivot;
        SWAP_COUNT++;

        // Deeper partitions.
        int[] lesser = Arrays.copyOfRange(arr, 0, i);
        if (lesser.length > 1) {
            lesser = quickSort(lesser);
        }

        int[] greater = Arrays.copyOfRange(arr, i + 1, arr.length);
        if (greater.length > 1) {
            greater = quickSort(greater);
        }

        // Merge.
        return merge(arr.length, pivot, lesser, greater);
    }

    private static int[] merge(int len, int pivot, int[] lesser, int[] greater) {
        int[] arr = new int[len];

        int i = 0;
        while (i < lesser.length) {
            arr[i] = lesser[i];
            i++;
        }
        arr[i] = pivot;
        i++;

        int j = 0;
        while (j < greater.length) {
            arr[i] = greater[j];
            j++;
            i++;
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
        arr = quickSort(arr);
        scanner.close();
    }

}
