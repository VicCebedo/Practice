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
public class InsertNodeAtTail {

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode last = new SinglyLinkedListNode(data);

        // If list is empty, just return the data as head.
        if (head == null) {
            head = last;
            return head;
        }

        SinglyLinkedListNode previous = null;
        while (head != null) {
            previous = head;
            previous.next = head.next;
            head = head.next;
        }

        previous.next = last;
        return previous;
    }
}
