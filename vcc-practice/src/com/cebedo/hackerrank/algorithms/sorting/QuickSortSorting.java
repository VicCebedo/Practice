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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class QuickSortSorting {

    private static List<Integer> quickSort(int[] arr) {
        int pivot = arr[0];
        List<Integer> lessThan = new ArrayList<>();
        List<Integer> greaterThan = new ArrayList<>();

        // Do partitioning.
        for (int num : arr) {
            if (num < pivot) {
                lessThan.add(num);
            } else if (num > pivot) {
                greaterThan.add(num);
            }
        }

        if (lessThan.size() > 1) {
            lessThan = partition(lessThan);
        }
        if (greaterThan.size() > 1) {
            greaterThan = partition(greaterThan);
        }

        return merge(pivot, lessThan, greaterThan);
    }

    private static List<Integer> partition(List<Integer> arr) {
        return quickSort(arr.stream().mapToInt(i -> i).toArray());
    }

    private static List<Integer> merge(int pivot, List<Integer> lessThan, List<Integer> greaterThan) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(lessThan);
        merged.add(pivot);
        merged.addAll(greaterThan);
        for (int num : merged) {
            System.out.print(num + " ");
        }
        System.out.println();
        return merged;
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
        quickSort(arr);
        scanner.close();
    }
}
