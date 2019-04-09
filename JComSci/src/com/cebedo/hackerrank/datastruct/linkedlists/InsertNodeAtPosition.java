/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.linkedlists;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class InsertNodeAtPosition {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode current, int data, int position) {

        // If null, just return the node.
        SinglyLinkedListNode middleNode = new SinglyLinkedListNode(data);
        if (current == null) {
            return middleNode;
        }

        int currentIndex = 0;
        SinglyLinkedListNode newStart = null;

        // Traverse through the entire list.
        while (current != null) {

            // If we have found the desired position.
            if (currentIndex == position) {
                newStart = middleNode;
                newStart.next = current;
                break;
            }
            newStart = new SinglyLinkedListNode(current.data);
            newStart.next = new SinglyLinkedListNode(current.next.data);
            current = current.next;
            currentIndex++;
        }
        return newStart;
    }
}
