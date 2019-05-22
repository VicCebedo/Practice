/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.trees;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int d) {
        this.data = d;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }

}
