/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.linkedlists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class HasCycle {

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }

        // While there is a next, proceed.
        int dataCount = 0;
        Map<Integer, List<SinglyLinkedListNode>> dataMap = new HashMap<>();
        while (head != null) {

            // If we have exceeding the constraint,
            // return false.
            dataCount++;
            if (dataCount > 1000) {
                return false;
            }

            // Get the current list.
            int currentData = head.data;
            List<SinglyLinkedListNode> nodesWithSameData = dataMap.get(currentData);

            if (nodesWithSameData == null) {
                // If null, then insert a new list with this data.
                List<SinglyLinkedListNode> newList = new ArrayList<>();
                newList.add(head);
                dataMap.put(currentData, newList);
            } else {
                // Else, check if this head has already been here before.
                for (SinglyLinkedListNode node : nodesWithSameData) {
                    if (node == head) {
                        return true;
                    }
                }

                // Else, add this to the list.
                nodesWithSameData.add(head);
                dataMap.put(currentData, nodesWithSameData);
            }

            head = head.next;
        }
        return false;
    }
}
