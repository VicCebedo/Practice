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
package com.cebedo.hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class InsertionSort2 {

    static void insertionSort2(int n, int[] arr) {
        while (!isSorted(arr)) {
            for (int i = 0; i < arr.length; i++) {
                if (i - 1 >= 0) {
                    int current = arr[i];
                    int previous = arr[i - 1];
                    if (current < previous) {
                        shiftAndInsert(i, arr, current);
                    }
                    print(arr);
                }
            }
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void shiftAndInsert(int index, int[] arr, int toInsert) {
        boolean inserted = false;
        while (index - 1 >= 0) {
            int previous = arr[index - 1];
            if (previous < toInsert) {
                arr[index] = toInsert;
                inserted = true;
                break;
            } else {
                arr[index] = previous;
            }
            index--;
        }

        if (!inserted) {
            arr[0] = toInsert;
        }
    }

    private static void print(int[] arr) {
        String[] str = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", str));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        insertionSort2(n, arr);
        scanner.close();
    }
}
