/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hr.datastruct.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MatchingStrings {

    static int[] matchingStrings(String[] strings, String[] queries) {

        // Check constraints.
        if (strings == null || queries == null
                || strings.length > 1000 || queries.length > 1000) {
            return new int[0];
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (String str : strings) {

            // If does not exist, add one.
            // Else, add one over the current value.
            Integer currentValue = countMap.get(str);
            if (currentValue == null) {
                countMap.put(str, 1);
            } else {
                countMap.put(str, currentValue + 1);
            }
        }

        // For each query, get the count from the map.
        int returnArrIndex = 0;
        int[] returnArr = new int[queries.length];
        for (String query : queries) {
            Integer count = countMap.get(query);
            returnArr[returnArrIndex] = count == null ? 0 : count;
            returnArrIndex++;
        }
        return returnArr;
    }
}
