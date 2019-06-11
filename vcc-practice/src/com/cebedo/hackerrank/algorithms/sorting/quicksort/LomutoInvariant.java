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
package com.cebedo.hackerrank.algorithms.sorting.quicksort;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class LomutoInvariant {

    private static boolean INVARIANT_FIRST_RUN = true;
    private static int[] INVARIANT_ARRAY;
    private static int[] INVARIANT_LESSER;

    private static int[] quickSort(int[] arr) {

        int pivot = arr[arr.length - 1];
        int fastIndex = 0;
        int slowIndex = fastIndex - 1;

        if (INVARIANT_FIRST_RUN) {
            INVARIANT_ARRAY = arr;
            INVARIANT_FIRST_RUN = false;
        }

        while (fastIndex < arr.length) {

            int currentValue = arr[fastIndex];

            // If current value is greater than pivot,
            // do nothing. But if current value is less than pivot,
            // increment the slow index, then swap with fast index.
            if (currentValue < pivot) {
                slowIndex++;
                arr[fastIndex] = arr[slowIndex];
                arr[slowIndex] = currentValue;
            }
            fastIndex++;
        }

        // Swap the pivot to appropriate place.
        slowIndex++;
        arr[arr.length - 1] = arr[slowIndex];
        arr[slowIndex] = pivot;

        // Print invariant.
        if (arr.length == INVARIANT_ARRAY.length) {
            print(arr);
        }

        // Get lesser and greater range,
        // then recursively sort.
        fastIndex--;
        int[] lesser = Arrays.copyOfRange(arr, 0, slowIndex);
        if (lesser.length > 1) {
            lesser = quickSort(lesser);
            INVARIANT_LESSER = lesserInvariant(lesser, pivot);
            print(INVARIANT_LESSER);
        }

        int[] greater = Arrays.copyOfRange(arr, slowIndex + 1, arr.length);
        if (greater.length > 1) {
            greater = quickSort(greater);
            int[] temp = merge(arr.length, pivot, lesser, greater);
            print(temp);
        }

        return merge(arr.length, pivot, lesser, greater);
    }

    private static int[] lesserInvariant(int[] lesserArr, int pivot) {
        List<Integer> lesser = Arrays.stream(lesserArr).boxed().collect(Collectors.toList());
        lesser.add(pivot);
        for (int i = lesser.size(); i < INVARIANT_ARRAY.length; i++) {
            lesser.add(INVARIANT_ARRAY[i]);
        }
        return lesser.stream().mapToInt(i -> i).toArray();
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

    private static void print(int[] arr) {
        String[] str = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", str));
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
