/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hr.algorithms.recursion;

/**
 *
 * @author Vic Cebedo
 */
public class PowerSum {

    static int powerSum(int X, int N) {

        // Get the floor Nth root of X.
        int total = 0;
        int nthRoot = (int) Math.floor(calculateNthRoot(X, N));

        while (true) {
            // total += Math.pow(N, N)
            break;
        }

        return 0;
    }

    static int test() {
        return 0;
    }

    static double calculateNthRoot(double base, double n) {
        return Math.pow(Math.E, Math.log(base) / n);
    }
}
