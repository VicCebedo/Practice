/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.ctci.arrays;

/**
 * Write a method to replace all spaces in a string with "%20". You may assume
 * that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class AsUrl {

    public char[] convert(String given, int trueLength) {
        // Count how many spaces.
        // Double the count of spaces, because we need to replace ' ' with '%20'.
        char[] s = given.toCharArray();
        int spaceCount = spaceCount(s, trueLength);

        // TODO Not necessary to do this.
        // It is already assumed that "the string has sufficient space at the
        // end to hold the additional characters".
        char[] extendedArray = extendArrayLength(s, trueLength, spaceCount * 2);

        // Loop the original string backwards.
        // When you meet non-empty character, copy it.
        // Else, replace with %20.
        int extendedIndex = extendedArray.length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            char currentChar = s[i];
            if (currentChar == 32 || currentChar == 0) {
                // If space or null.
                // Then add 0, 2, %.
                extendedArray[extendedIndex] = '0';
                extendedArray[extendedIndex - 1] = '2';
                extendedArray[extendedIndex - 2] = '%';
                extendedIndex = extendedIndex - 3;
            } else {
                // Else, copy current character to current index.
                extendedArray[extendedIndex] = currentChar;
                extendedIndex--;
            }
        }
        return extendedArray;
    }

    /**
     * Extend the length of the array to make room for shifting.
     *
     * @param s
     * @param extension
     * @return
     */
    private char[] extendArrayLength(char[] s, int trueLength, int extension) {
        char[] extendedArray = new char[trueLength + extension];
        for (int i = 0; i < trueLength; i++) {
            extendedArray[i] = s[i];
        }
        return extendedArray;
    }

    /**
     * Count number of spaces between start of string to true length.
     *
     * @param s
     * @param trueLength
     * @return
     */
    private int spaceCount(char[] s, int trueLength) {
        int count = 0;
        for (int i = 0; i < trueLength; i++) {
            char c = s[i];
            if (c == 32) {
                count++;
            }
        }
        return count;
    }

}
