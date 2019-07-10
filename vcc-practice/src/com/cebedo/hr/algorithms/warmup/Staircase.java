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
package com.cebedo.hr.algorithms.warmup;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Staircase {

    static void staircase(int n) {
        StringBuilder spaces = new StringBuilder();
        StringBuilder stairs = new StringBuilder("#");
        int nCopy = n;
        while (nCopy > 1) {
            spaces.append(" ");
            nCopy--;
        }

        while (n > 0) {

            System.out.print(spaces.toString());
            System.out.println(stairs.toString());

            // Next.
            if (spaces.length() > 0) {
                spaces.deleteCharAt(spaces.length() - 1);
            }
            stairs.append("#");
            n--;
        }
    }

    public static void main(String[] args) {
        staircase(4);
    }

}
