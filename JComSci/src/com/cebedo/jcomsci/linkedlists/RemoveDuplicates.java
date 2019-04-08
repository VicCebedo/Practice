/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.jcomsci.linkedlists;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Write code to remove duplicates from an unsorted linked list. Follow up: How
 * would you solve this problem if a temporary buffer is not allowed?
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedList<Integer> listWithDuplicates = new LinkedList<>();
        listWithDuplicates.add(4);
        listWithDuplicates.add(5);
        listWithDuplicates.add(1);
        listWithDuplicates.add(4);
        listWithDuplicates.add(4);
        listWithDuplicates.add(4);
        listWithDuplicates.add(5);
        listWithDuplicates.add(9);
        listWithDuplicates.add(10);
        new RemoveDuplicates().runWithoutBuffer(listWithDuplicates);
    }

    public LinkedList<Integer> runWithBuffer(LinkedList<Integer> listWithDuplicates) {
        HashSet<Integer> removedDuplicates = new HashSet<>(listWithDuplicates);
        return new LinkedList<>(removedDuplicates);
    }

    public void runWithoutBuffer(LinkedList<Integer> inputList) {
        // Input:  [4,5,1,4,5,9,10]
        // Output: [4,5,1,9,10]

        // Sort the linked list.
        // Sorted: [1,4,4,4,5,5,9,10]
        Collections.sort(inputList);

        // Go through each element.
        int fastPointer = 1;
        for (int slowPointer = 0; slowPointer < inputList.size(); slowPointer++) {

            // If the current element is equal to the next,
            // go to the next index (via slow pointer) and set it to null.
            int previousElem = inputList.get(slowPointer);
            if (Objects.equals(previousElem, inputList.get(fastPointer))) {
                slowPointer++;
                fastPointer++;
                inputList.set(slowPointer, null);
                // The fast pointer will search for the next element that is not
                // equal to the previous element (current element is now null).
                while (Objects.equals(previousElem, inputList.get(fastPointer))) {
                    fastPointer++;
                }
                // Once we find the index of the not equal element,
                // set the current element to the value of the fast index.
                inputList.set(slowPointer, inputList.get(fastPointer));
            } else {

                // If not equal,
                // just copy the value to the slow pointer's location.
                inputList.set(slowPointer, inputList.get(fastPointer));
            }
            fastPointer++;
        }
        System.out.println(inputList);
    }
}
