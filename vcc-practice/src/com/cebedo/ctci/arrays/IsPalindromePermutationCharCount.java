/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.ctci.arrays;

/**
 * Given a string, write a function to check if it is a palindrome permutation.
 * A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class IsPalindromePermutationCharCount {

    // TODO Learn how to exclude special characters, only alphabets must be considered.
    // Assumption: We only accept up to ASCII #122 ('z').
    private static final int ALLOWED_ASCII_LIMIT = 122;

    public boolean isPalindrome(String s) {
        int[] charCount = countChars(s);
        boolean oddFound = false;
        for (int i = 0; i < charCount.length; i++) {
            // Loop through each count.
            // If there is more than one odd, then this is not a palindrome.
            if (charCount[i] % 2 > 0) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }
        return true;
    }

    /**
     * Count how many per character.
     *
     * @param s
     * @return
     */
    private int[] countChars(String s) {
        int[] charCount = new int[ALLOWED_ASCII_LIMIT];
        for (char c : s.toCharArray()) {
            charCount[c] = charCount[c] + 1;
        }
        return charCount;
    }
}
