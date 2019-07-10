/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hr.algorithms.sorting;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class BigSort {

    static String[] bigSorting(String[] unsorted) {
        return null;
    }

    static boolean isUpperCase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return 65 <= str.charAt(0) && str.charAt(0) <= 90;
    }

    public static void main(String[] args) {
        System.out.println(isUpperCase("aSDASDASDGEGHUNTU"));
    }
}
