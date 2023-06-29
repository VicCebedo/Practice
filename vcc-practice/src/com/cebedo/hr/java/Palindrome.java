/*
 * The MIT License
 *
 * Copyright 2023 vcebedo.
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
package com.cebedo.hr.java;

import java.util.Scanner;

/**
 *
 * @author vcebedo
 */
public class Palindrome {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();

            int front = 0;
            int back = input.length() - 1;
            boolean palindrome = true;

            while (true) {

                // If we have reached the middle.
                if (front == back) {
                    break;
                }

                // If we have reached the end.
                if (front == input.length()) {
                    break;
                }

                char charFront = input.charAt(front);
                char charBack = input.charAt(back);

                if (charFront == charBack) {
                    front++;
                    back--;
                } else {
                    palindrome = false;
                    break;
                }
            }

            System.out.println(palindrome ? "Yes" : "No");
        }
    }
}
