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
package com.cebedo.hackerrank.algorithms.warmup;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MiniMaxSum {

    public static void main(String[] args) {
        int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625};
        miniMaxSum(arr);
    }

    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        BigInteger min = BigInteger.valueOf(arr[0])
                .add(BigInteger.valueOf(arr[1]))
                .add(BigInteger.valueOf(arr[2]))
                .add(BigInteger.valueOf(arr[3]));
        BigInteger max = BigInteger.valueOf(arr[1])
                .add(BigInteger.valueOf(arr[2]))
                .add(BigInteger.valueOf(arr[3]))
                .add(BigInteger.valueOf(arr[4]));
        System.out.print(min.toString() + " " + max.toString());
    }
}
