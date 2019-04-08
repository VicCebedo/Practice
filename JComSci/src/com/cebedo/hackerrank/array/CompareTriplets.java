/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class CompareTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        if (a == null || b == null) {
            return returnZeros();
        }

        int aPoints = 0;
        int bPoints = 0;

        for (int i = 0; i < 3; i++) {

            // Check if the given are valid.
            // If given values are valid, proceed.
            int aValue = a.get(i);
            int bValue = b.get(i);
            if (inRange(aValue) && inRange(bValue)) {

                // If a > b, a points++.
                // If b > a, b points++.
                if (aValue > bValue) {
                    aPoints++;
                } else if (bValue > aValue) {
                    bPoints++;
                }
            } else {
                return returnZeros();
            }
        }
        List<Integer> returnObj = new ArrayList<>(2);
        returnObj.add(0, aPoints);
        returnObj.add(1, bPoints);
        return returnObj;
    }

    static List<Integer> returnZeros() {
        List<Integer> results = new ArrayList<>(2);
        results.add(0);
        results.add(0);
        return results;
    }

    static boolean inRange(Integer given) {
        if (given == null) {
            return false;
        }
        return 1 <= given && given <= 100;
    }
}
