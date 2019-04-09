/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.ctci.arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class IsPermutation {

    // Assumption: We only accept up to ASCII #122 ('z').
    private static final int ALLOWED_ASCII_LIMIT = 122;

    /**
     * Count how many times a character occurred.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean check(String s1, String s2) {
        // Check if our inputs are valid.
        if (!isValid(s1, s2)) {
            return false;
        }

        // Count number of occurrences per character.
        int[] countPerChar = countPerChar(s1);

        // Now, use the second string input against the count and 
        // decrement each count for every occurence.
        for (char c : s2.toCharArray()) {
            int newCount = countPerChar[c] - 1;

            // If count is negative one (due to zero, or decrement).
            if (newCount == -1) {
                return false;
            }

            // Else, put new decremented value.
            countPerChar[c] = newCount;
        }
        return true;
    }

    /**
     * Count number of occurrences per character.
     *
     * @param s
     * @return
     */
    private int[] countPerChar(String s) {
        int[] charCount = new int[ALLOWED_ASCII_LIMIT];
        for (char c : s.toCharArray()) {
            if (c > ALLOWED_ASCII_LIMIT) {
                throw new IllegalArgumentException();
            }
            charCount[c] = charCount[c] == 0
                    ? 1
                    : charCount[c] + 1;
        }
        return charCount;
    }

    private boolean isValid(String s1, String s2) {
        return s1.length() == s2.length();
    }

}
