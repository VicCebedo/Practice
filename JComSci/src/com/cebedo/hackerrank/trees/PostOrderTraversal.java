/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.trees;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class PostOrderTraversal {

    private static StringBuilder sb = new StringBuilder();
    private static Stack<Node> stack = new Stack<>();
    private static Set<Node> visited = new HashSet<>();
    private static int nodeCount = 0;

    public static void postOrder(Node root) {
        doPostOrder(root);
        System.out.print(sb.toString());
    }

    static void doPostOrder(Node root) {

        nodeCount++;
        if (!(nodeCount > 500 || root == null)) {

            // If we have already visited the left and the right,
            // OR If we have reached a deadend.        
            // visit this node,
            // then pop from stack.
            if ((visited.contains(root.left) && visited.contains(root.right))
                    || (root.left == null && root.right == null)) {
                visitNode(root);
                if (!stack.isEmpty()) {
                    doPostOrder(stack.pop());
                }
            } else {
                // If we can go left or maybe we can go right,
                // push root to stack,
                // push right to stack,
                // go to left.
                if (root.left != null) {
                    if (!visited.contains(root)) {
                        stack.push(root);
                    }

                    // If we can go right, we go right later.
                    if (root.right != null && !visited.contains(root.right)) {
                        stack.push(root.right);
                    }

                    // If we have already visited the left,
                    if (visited.contains(root.left)) {
                        doPostOrder(stack.pop());
                    } else {
                        doPostOrder(root.left);
                    }
                } else if (root.right != null) {

                    // If we cannot go left,
                    // but we can go right,
                    // push root to stack, then visit right.
                    visited.add(root.left);
                    if (!visited.contains(root)) {
                        stack.push(root);
                    }
                    doPostOrder(root.right);
                }
            }
        }
    }

    static void visitNode(Node node) {
        sb.append(node.data).append(" ");
        visited.add(node);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        postOrder(root);
    }
}
