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
public class InsertNodeAtHead {

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode current, int data) {
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
        if (current == null) {
            return newHead;
        }
        newHead.next = current;
        return newHead;
    }
}
