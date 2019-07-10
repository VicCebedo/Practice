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
package com.cebedo.hr.preparation.search;

import java.util.Arrays;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Triplets {

    static long triplets(int[] a, int[] b, int[] c) {

        int[] sortedA = Arrays.stream(a).sorted().distinct().toArray();
        int[] sortedB = Arrays.stream(b).sorted().distinct().toArray();
        int[] sortedC = Arrays.stream(c).sorted().distinct().toArray();

        // Indices are declared here since this can always go forward
        // because the arrays are already sorted.
        int leftIndex = 0;
        int leftCount = 0;
        int rightIndex = 0;
        int rightCount = 0;
        long countTotal = 0;

        for (int i = 0; i < sortedB.length; i++) {

            int valueB = sortedB[i];

            // Count the number of occurences where
            // B is greater than or equal to A.
            while (leftIndex < sortedA.length && valueB >= sortedA[leftIndex]) {
                leftCount++;
                leftIndex++;
            }

            // Count the number of occurences where
            // B is greater than or equal to C.
            while (rightIndex < sortedC.length && valueB >= sortedC[rightIndex]) {
                rightCount++;
                rightIndex++;
            }

            countTotal += (long) leftCount * (long) rightCount;
        }

        return countTotal;
    }
}
