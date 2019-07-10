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
package com.cebedo.hr.datastruct.array;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Array2d {

    static int hourglassSum(int[][] arr) {
        // Constraints.
        int maxLength = 6;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < maxLength - 2; i++) {
            for (int j = 0; j < maxLength - 2; j++) {
                int currentHourGlass = getCurrentTotal(arr, i, j);
                max = currentHourGlass > max
                        ? currentHourGlass
                        : max;
            }
        }
        return max;
    }

    static int getCurrentTotal(int[][] arr, int i, int j) {
        // Top.
        int value00 = arr[i][j];
        int value01 = arr[i][j + 1];
        int value02 = arr[i][j + 2];

        // Mid.
        int value11 = arr[i + 1][j + 1];

        // Bottom.
        int value20 = arr[i + 2][j];
        int value21 = arr[i + 2][j + 1];
        int value22 = arr[i + 2][j + 2];
        return value00 + value01 + value02 + value11 + value20 + value21 + value22;
    }
}
