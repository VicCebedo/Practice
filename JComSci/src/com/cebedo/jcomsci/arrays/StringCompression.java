/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.jcomsci.arrays;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string "aabcccccaaa" would become
 * "a2b1c5a3". If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a-z).
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress("aaAaa"));
    }

    public String compress(String s) {
        int count = 1;
        char previous = s.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            // You can assume the string has only uppercase
            // and lowercase letters (a-z).
            if (!(this.isValid(current) && this.isValid(previous))) {
                throw new IllegalArgumentException();
            }

            if (previous == current) {
                count++;
            } else {
                sb.append(previous);
                sb.append(count);
                count = 1;
            }
            previous = current;

            // If the "compressed" string would not become smaller than the
            // original string, your method should return the original string.
            if (s.length() < sb.length()) {
                return s;
            }
        }
        sb.append(previous);
        sb.append(count);
        return sb.toString();
    }

    /**
     * A character is valid if it is between a to z.
     *
     * @param c
     * @return
     */
    private boolean isValid(char c) {
        return (Integer.hashCode(c) >= Integer.hashCode('a')
                && Integer.hashCode(c) <= Integer.hashCode('z'))
                || (Integer.hashCode(c) >= Integer.hashCode('A')
                && Integer.hashCode(c) <= Integer.hashCode('Z'));
    }

}
