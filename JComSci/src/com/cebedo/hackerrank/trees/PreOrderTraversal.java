/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.trees;

import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class PreOrderTraversal {

    private static StringBuilder sb = new StringBuilder();
    private static Stack<Node> stack = new Stack<>();
    private static int nodeCount = 0;

    public static void preOrder(Node root) {
        doPreOrder(root);
        System.out.print(sb.toString());
    }

    static void doPreOrder(Node root) {
        // Visit root.
        nodeCount++;
        if (nodeCount > 500) {
            return;
        }
        visitNode(root);

        // If left and right is not null,
        // add right to stack.
        if (root.left != null && root.right != null) {
            stack.add(root.right);

            // Visit left.
            doPreOrder(root.left);
        }

        // If we have reached a deadend,
        // pop last one in stack.
        if (root.left == null && root.right == null) {

            // If stack size is empty,
            // then we are done.
            if (stack.isEmpty()) {
                return;
            }
            doPreOrder(stack.pop());
        }

        // If left is null, but right is not.
        if (root.left == null && root.right != null) {
            doPreOrder(root.right);
        }

        // If left is not null, but right is.
        if (root.left != null && root.right == null) {
            doPreOrder(root.left);
        }
    }

    static void visitNode(Node node) {
        sb.append(node.data).append(" ");
    }
}
