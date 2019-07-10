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
public class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int d) {
        this.data = d;
    }

    @Override
    public String toString() {
        return "{" + "data=" + data + "}";
    }

}
