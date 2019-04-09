/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.ctci.arrays;

/**
 * Assume you have a given method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to check if s2
 * is a rotation of s1 using only one call to isSubstring (e.g., "waterbottle"
 * is a rotation of "erbottlewat").
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class StringRotation {

    public static void main(String[] main) {
        System.out.println(new StringRotation().isRotation("waterbottle", "erbottlewat"));
    }

    public boolean isRotation(String original, String toCheck) {
        StringBuilder sb = new StringBuilder();
        sb.append(toCheck);
        sb.append(toCheck);
        return sb.toString().contains(original);
    }

}
