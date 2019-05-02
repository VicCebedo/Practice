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

import java.io.IOException;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MergeLists {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;
        SinglyLinkedListNode previous = null;

        while (true) {

            if (current1 == null || current2 == null) {
                return head1;
            }

            SinglyLinkedListNode realNext1 = current1.next;
            SinglyLinkedListNode realNext2 = current2.next;

            // If head1 is less than head2, proceed to next.
            if (current1.data < current2.data) {
                previous = current1;

                // Next.
                current1 = current1.next;
                continue;
            }

            if (current1.data > current2.data) {
                if (previous == null) {
                    SinglyLinkedListNode newHead = new SinglyLinkedListNode(current2.data);
                    newHead.next = current1;

                    // Next, don't move pointer of current1 because we
                    // only inserted in the head.
                    previous = newHead;
                } else {
                    previous.next = current2;
                    current2.next = current1;

                    // Next.
                    previous = current1;
                    current1 = current1.next;
                    current2 = realNext2;
                }
                continue;
            }

            // If head1 is equal with head2.
            current1.next = current2;
            current2.next = realNext1;

            // Next.
            previous = current2;
            current1 = realNext1;
            current2 = realNext2;
        }
    }

    public static void main(String[] args) throws IOException {

        int[] h1 = {2, 4, 6, 8};
        int[] h2 = {2, 3, 7};
        SinglyLinkedListNode head1 = constructLinkedList(h1);
        SinglyLinkedListNode head2 = constructLinkedList(h2);
        SinglyLinkedListNode merged = mergeLists(head1, head2);
        while (merged != null) {
            System.out.println(merged.data + " ");
            merged = merged.next;
        }
    }

    public static SinglyLinkedListNode constructLinkedList(int[] h) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(h[0]);
        SinglyLinkedListNode headPointer = head;
        boolean firstRun = true;

        for (int h1Data : h) {
            if (firstRun) {
                firstRun = false;
                continue;
            }
            headPointer.next = new SinglyLinkedListNode(h1Data);
            headPointer = headPointer.next;
        }
        return head;
    }
}
