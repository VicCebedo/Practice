/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hr.algorithms.greedy;

/**
 *
 * @author Vic Cebedo
 */
public class MinAbsDiff {

    static int minimumAbsoluteDifference(int[] arr) {

        if (!(2 <= arr.length && arr.length <= 100000)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int[] done = new int[100000];

        for (int slowPointer = 0; slowPointer < arr.length; slowPointer++) {
            for (int fastPointer = 0; fastPointer < arr.length; fastPointer++) {

                // If slow and fast is equal, skip it.
                // Or if order/reversed order already exists.
                if (slowPointer == fastPointer
                        || isExist(done, slowPointer, fastPointer)) {
                    continue;
                }

                int absDiff = absDiff(arr[slowPointer], arr[fastPointer]);
                if (absDiff < min) {
                    min = absDiff;
                }

                // Add to map with key so that we won't compute this again.
                done[slowPointer] = fastPointer;
                done[fastPointer] = slowPointer;
            }
        }
        return min;
    }

    static boolean isExist(int[] done, int indexA, int indexB) {
        return done[indexA] == indexB || done[indexB] == indexA;
    }

    static int absDiff(int a, int b) {
//        if (inRange(a) && inRange(b)) {
//            return Math.abs(a - b);
//        }
        return Math.abs(a - b);
    }

    static boolean inRange(int value) {
        return (Math.pow(10, 9) * -1) <= value && value <= Math.pow(10, 9);
    }
}
