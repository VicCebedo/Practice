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
package com.cebedo.hackerrank.algorithms.sorting.countingsort;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class CountingSort {

    static int[] countingSort(int[] arr) {
        // Count.
        int[] count = count(arr);

        // Increment.
        increment(count);

        // Shift.
        shift(count);

        // Sort.
        int[] sorted = new int[arr.length];
        for (int num : arr) {
            int index = count[num];
            count[num]++;
            sorted[index] = num;
        }
        return sorted;
    }

    private static void shift(int[] count) {
        int current = count.length - 1;
        int previous = current - 1;

        while (previous >= 0) {
            count[current] = count[previous];
            current--;
            previous--;
        }
        count[0] = 0;
    }

    private static void increment(int[] count) {
        int current = 0;
        int ahead = current + 1;

        while (ahead < count.length) {
            count[ahead] = count[ahead] + count[current];
            current++;
            ahead++;
        }
    }

    private static int[] count(int[] arr) {
        int[] count = new int[100];
        for (int num : arr) {
            count[num]++;
        }
        return count;
    }

}
