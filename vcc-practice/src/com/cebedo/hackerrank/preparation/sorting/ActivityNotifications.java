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
package com.cebedo.hackerrank.preparation.sorting;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class ActivityNotifications {

    private static final int MAX_AMOUNT = 200;
    private static boolean FIRST_RUN = true;

    static int activityNotifications(int[] expenditure, int d) {
        int[] data = new int[d];
        int dataIndex = 0;

        int i = 0;
        int noticeCount = 0;
        while (i < expenditure.length) {

            // If we don't have enough data to get the median,
            // then collect for now.
            int amount = expenditure[i];
            if (dataIndex < d) {
                data[dataIndex] = amount;
                dataIndex++;
                i++;
                continue;
            }

            // If we have enough data,
            // compute the median.
            double median = computeMedian(data);
            if (amount >= (2 * median)) {
                noticeCount++;
            }

            // Shift the data to the left,
            // then add the current amount to the last.
            int j = data.length - 1;
            int k = j - 1;
            while (k >= 0) {
                data[k] = data[j];
                k--;
                j--;
            }
            data[data.length - 1] = amount;

            // Next.
            i++;
        }
        return noticeCount;
    }

    private static double computeMedian(int[] data) {
        if (FIRST_RUN) {
            data = countingSort(data);
            FIRST_RUN = false;
        } else {
            insertionSort(data);
        }
        boolean isEven = (data.length % 2) == 0;
        if (isEven) {
            int j = data.length / 2;
            int i = j - 1;
            return (data[j] + data[i]) / 2.0;
        }
        return data[data.length / 2];
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i - 1 >= 0) {
                int current = arr[i];
                int previous = arr[i - 1];
                if (current < previous) {
                    shiftAndInsert(i, arr, current);
                }
            }
        }
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
        int[] count = new int[MAX_AMOUNT];
        for (int num : arr) {
            count[num]++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];
        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }
        int result = activityNotifications(expenditure, d);
        scanner.close();
    }
}
