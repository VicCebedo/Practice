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
package com.cebedo.hackerrank.diligence;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        int[] countPerColor = new int[101];
        int total = 0;

        // For each color in the array,
        // count each occurence.
        for (int color : ar) {
            countPerColor[color] = countPerColor[color] + 1;
        }

        // For each count,
        // ignore all less than a pair.
        // For odds, minus one then divide by 2.
        // For evens, divide by 2.
        for (int count : countPerColor) {
            if (count < 2) {
                continue;
            }
            if (count % 2 > 1) {
                total += (count - 1) / 2;
            } else {
                total += (count / 2);
            }
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        int result = sockMerchant(n, ar);
        scanner.close();
    }

}
