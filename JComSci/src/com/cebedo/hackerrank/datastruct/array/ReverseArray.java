/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.array;

/**
 *
 * @author Vic Cebedo
 */
public class ReverseArray {

    static int[] reverseArray(int[] a) {
        int[] reversed = new int[a.length];
        int reversedIndex = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            reversed[reversedIndex] = a[i];
            reversedIndex++;
        }
        return reversed;
    }
}
