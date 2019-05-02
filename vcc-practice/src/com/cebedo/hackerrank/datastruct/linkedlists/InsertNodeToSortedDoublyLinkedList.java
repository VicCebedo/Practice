/*
 * The MIT License
 *
 * Copyright 2019 Vic Cebedo <cebedo.vii@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cebedo.hackerrank.datastruct.linkedlists;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class InsertNodeToSortedDoublyLinkedList {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode current = head;

        // Loop through each element.
        while (current != null) {

            // If we are at the start.
            if (current.prev == null && current.data > data) {
                DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
                newNode.next = current;
                return newNode;
            }

            // Find current > data.
            if (current.data > data) {
                doInsert(current, data);
                return head;
            }

            // If we are at the end.
            if (current.next == null) {
                DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
                current.next = newNode;
                newNode.prev = current;
                return head;
            }

            // Next;
            current = current.next;
        }
        return head;
    }

    private static void doInsert(DoublyLinkedListNode current, int data) {

        // Point the new node.
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        newNode.next = current;
        newNode.prev = current.prev;

        // Point the old previous.
        current.prev.next = newNode;
    }

}
