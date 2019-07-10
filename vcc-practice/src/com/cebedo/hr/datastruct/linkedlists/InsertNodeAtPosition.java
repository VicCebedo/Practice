/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hr.datastruct.linkedlists;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class InsertNodeAtPosition {

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        int index = 0;
        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode dataToInsert = new SinglyLinkedListNode(data);
        SinglyLinkedListNode current = head;

        while (current != null) {

            if (index == position) {
                previous.next = dataToInsert;
                dataToInsert.next = current;
                break;
            }

            // Proceed to next.
            index++;
            previous = current;
            current = current.next;
        }

        return head;
    }
}
