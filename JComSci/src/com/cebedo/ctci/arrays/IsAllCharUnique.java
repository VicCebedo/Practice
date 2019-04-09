/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.ctci.arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class IsAllCharUnique {

    // Assumption: We only accept up to ASCII #122 ('z').
    private static final int ALLOWED_ASCII_LIMIT = 122;

    public boolean check(String givenString) {
        // Each character inside the string must be mapped
        // to an array of booleans where the character will be mapped to the
        // index equivalent to its ASCII (hash code) value.
        boolean[] uniqueMap = new boolean[ALLOWED_ASCII_LIMIT];

        for (char c : givenString.toCharArray()) {
            if (c > ALLOWED_ASCII_LIMIT) {
                return false;
            }

            // Get the current value first,
            // check if it's existing.
            // If exists, then duplicate found. Else, proceed.
            if (uniqueMap[c]) {
                return false;
            }
            uniqueMap[c] = true;
        }
        // If entire loop finished without errors,
        // then entire array is unique.
        return true;
    }

}
