/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.linkedlists;

import java.io.IOException;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class InsertNodeAtTail {

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }
        SinglyLinkedListNode current = head;

        // Loop infinitely.
        while (true) {
            // If we encounter the deadend,
            // set the next to new data.
            if (current.next == null) {
                current.next = new SinglyLinkedListNode(data);
                return head;
            }
            current = current.next;
        }
    }

    static class SinglyLinkedListNode {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist = new SinglyLinkedList();
        int[] inputs = {5, 141, 302, 164, 530, 474};

        for (int input : inputs) {
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, input);
            llist.head = llist_head;
        }
    }
}
