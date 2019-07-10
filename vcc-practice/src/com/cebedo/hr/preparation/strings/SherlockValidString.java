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
package com.cebedo.hr.preparation.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class SherlockValidString {

    private static final int ALPHABET_LENGTH = 26;
    private static final int LETTER_A = 65;

    static String isValid(String s) {

        int[] charCounts = new int[ALPHABET_LENGTH];

        for (char character : s.toUpperCase().toCharArray()) {
            charCounts[character - LETTER_A]++;
        }

        // Get the most common count.
        Map<Integer, Integer> countOfCounts = new HashMap<>();
        for (int count : charCounts) {
            if (count == 0) {
                continue;
            }
            Integer val = countOfCounts.get(count);
            countOfCounts.put(count, val == null
                    ? 1
                    : val + 1);
        }

        int mostCommonCount = 0;
        int highestValue = Integer.MIN_VALUE;
        for (int count : countOfCounts.keySet()) {
            int value = countOfCounts.get(count);
            if (value > highestValue) {
                highestValue = value;
                mostCommonCount = count;
            }
        }

        // Is the current count equal to the common count?
        // If not, +1 not equal.
        // If not equal == 2, return NO.
        for (int i = 0; i < charCounts.length; i++) {
            int count = charCounts[i];
            if (count == 0 || count == mostCommonCount) {
                continue;
            }
            charCounts[i] = count - 1;
            break;
        }

        // Is the current count equal to the common count?
        // If not, +1 not equal.
        // If not equal == 2, return NO. 
        for (int count : charCounts) {
            if (count == 0 || count == mostCommonCount) {
                continue;
            }
            return "NO";
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        String result = isValid(s);
        scanner.close();
    }

}
