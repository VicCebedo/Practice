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
package com.cebedo.hackerrank.preparation.strings;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MakeAnagram {

    private static final int ALPHABET_LENGTH = 26;
    private static final int LETTER_A = 65;

    static int makeAnagram(String a, String b) {

        int[] chars = new int[ALPHABET_LENGTH];

        for (char letter : a.toUpperCase().toCharArray()) {
            chars[letter - LETTER_A]++;
        }

        for (char letter : b.toUpperCase().toCharArray()) {
            chars[letter - LETTER_A]--;
        }

        int sum = 0;
        for (int count : chars) {
            sum += count < 0 ? count * -1 : count;
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int res = makeAnagram(a, b);
        scanner.close();
    }
}
