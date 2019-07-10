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

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Pairs {

    static int pairs(int target, int[] arr) {
        int count = 0;

        // Add all values to set.
        Set<Integer> valueSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            valueSet.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int part1 = arr[i];
            int part2 = part1 + target;

            // We are counting how many part1's can be paired with part2's.
            // So, if part2 exists in the set, then we have a pair.
            if (valueSet.contains(part2)) {
                count++;
            }
        }

        return count;
    }

    static int pairsSlow(int k, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] - arr[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
