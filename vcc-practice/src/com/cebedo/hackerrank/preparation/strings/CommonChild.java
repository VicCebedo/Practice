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
public class CommonChild {

    private static final int ALPHABET_LEN = 26;
    private static final int LETTER_A = 65;

    private static boolean[] existingCharacters(String s) {
        boolean[] existingChars = new boolean[ALPHABET_LEN];
        for (char letter : s.toUpperCase().toCharArray()) {
            existingChars[letter - LETTER_A] = true;
        }
        return existingChars;
    }

    private static boolean isExistInBoth(boolean[] existingChars1, boolean[] existingChars2, char letter) {
        return existingChars1[letter - LETTER_A] && existingChars2[letter - LETTER_A];
    }

    private static String createNewString(String s, boolean[] existingChars1, boolean[] existingChars2) {
        StringBuilder builder = new StringBuilder();
        for (char letter : s.toUpperCase().toCharArray()) {
            if (isExistInBoth(existingChars1, existingChars2, letter)) {
                builder.append(letter);
            }
        }
        return builder.toString();
    }

    static int commonChild(String s1, String s2) {

        // Get all chars present in both sides.
        boolean[] existingChars1 = existingCharacters(s1);
        boolean[] existingChars2 = existingCharacters(s2);

        // Create a substring of the two inputs,
        // based only on characters that are existing in both strings.
        s1 = createNewString(s1, existingChars1, existingChars2);
        s2 = createNewString(s2, existingChars1, existingChars2);

        int maxChild = 0;
        int lesserLength = s1.length() < s2.length()
                ? s1.length()
                : s2.length();
        for (int i = 0; i < lesserLength; i++) {
            if (s1.toUpperCase().charAt(i) == s2.toUpperCase().charAt(i)) {
                maxChild++;
            }
        }

//        while (s2Len > 0) {
//
//            String s1SubString = s1.substring(s1Index, s1Len);
//            String s2SubString = s2.substring(0, s2Len);
//            int common = commonChildLen(s1SubString, s2SubString);
//            if (common > maxChildLen) {
//                maxChildLen = common;
//            }
//
//            s1Index++;
//            s2Len--;
//        }
        return maxChild;
    }

    private static int commonChildLen(String s1, String s2) {
        int childLen = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                childLen++;
            }
        }
        return childLen;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);
        scanner.close();
    }

}
