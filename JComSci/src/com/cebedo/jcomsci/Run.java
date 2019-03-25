/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.jcomsci;

import com.cebedo.jcomsci.arrays.AsUrl;
import com.cebedo.jcomsci.arrays.IsPalindromePermutationCharCount;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Run {

    public static void main(String[] args) {
        // System.out.print(new IsPermutation().check("hhee", "hrhr"));
        // System.out.println(new IsAllCharUnique().check("abbc"));
        System.out.println(new IsPalindromePermutationCharCount().isPalindrome("bbbvva"));
        System.out.println(new AsUrl().convert("tttt    sss  qq", 13));
    }

}
