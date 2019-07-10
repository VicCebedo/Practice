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
package com.cebedo.hr.preparation.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MaximumToys {

    static int maximumToys(int[] prices, int k) {
        int[] sorted = quickSort(prices);

        int i = 0;
        int expenses = 0;
        int toyCount = 0;

        while (expenses + sorted[i] < k) {
            expenses += sorted[i];
            toyCount++;
            i++;
        }
        return toyCount;
    }

    private static int[] quickSort(int[] prices) {
        int j = 0;
        int i = j - 1;
        int pivot = prices[prices.length - 1];

        while (j < prices.length) {

            int currentValue = prices[j];
            if (currentValue < pivot) {
                i++;
                prices[j] = prices[i];
                prices[i] = currentValue;
            }
            j++;
        }

        i++;
        prices[prices.length - 1] = prices[i];
        prices[i] = pivot;

        // Deeper partitions.
        int[] lesser = Arrays.copyOfRange(prices, 0, i);
        if (lesser.length > 1) {
            lesser = quickSort(lesser);
        }
        int[] greater = Arrays.copyOfRange(prices, i + 1, prices.length);
        if (greater.length > 1) {
            greater = quickSort(greater);
        }

        return merge(prices.length, lesser, greater, pivot);
    }

    private static int[] merge(int len, int[] lesser, int[] greater, int pivot) {
        int[] merged = new int[len];
        int i = 0;
        while (i < lesser.length) {
            merged[i] = lesser[i];
            i++;
        }
        merged[i] = pivot;
        i++;
        int j = 0;
        while (j < greater.length) {
            merged[i] = greater[j];
            j++;
            i++;
        }
        return merged;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];
        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }
        int result = maximumToys(prices, k);
        scanner.close();
    }
}
