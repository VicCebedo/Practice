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

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class PlusMinus {

    public static void main(String[] args) {
        int[] arr = {-4, 3, -9, 0, 4, 1};
        plusMinus(arr);
    }

    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int num : arr) {
            switch (Integer.compare(num, 0)) {
                case -1: {
                    negative++;
                    break;
                }
                case 1: {
                    positive++;
                    break;
                }
                default: {
                    zero++;
                    break;
                }
            }
        }

        BigDecimal pos = BigDecimal.valueOf(positive);
        BigDecimal neg = BigDecimal.valueOf(negative);
        BigDecimal zed = BigDecimal.valueOf(zero);
        BigDecimal denominator = BigDecimal.valueOf(arr.length);
        System.out.println(pos.divide(denominator, 6, RoundingMode.HALF_UP).doubleValue());
        System.out.println(neg.divide(denominator, 6, RoundingMode.HALF_UP).doubleValue());
        System.out.println(zed.divide(denominator, 6, RoundingMode.HALF_UP).doubleValue());
    }

}
