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
package com.cebedo.hr.datastruct.trees;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class InOrderTraversal {

    private static final StringBuilder VISITED = new StringBuilder();
    private static final Stack<Node> STACK = new Stack<>();

    public static void inOrder(Node root) {
        doInOrder(root);
    }

    public static void doInOrder(Node currentNode) {
        while (true) {
            if (currentNode.left == null && currentNode.right == null) {
                visitNode(currentNode);
                if (STACK.isEmpty()) {
                    break;
                }
                doInOrder(STACK.pop());
                return;
            }

            if (currentNode.left == null && currentNode.right != null) {
                visitNode(currentNode);
                doInOrder(currentNode.right);
                return;
            }

            if (currentNode.left != null && currentNode.right == null) {
                if (isVisited(currentNode.left)) {
                    visitNode(currentNode);
                    if (STACK.isEmpty()) {
                        break;
                    }
                    doInOrder(STACK.pop());
                    return;
                }
                visitLater(currentNode);
                doInOrder(currentNode.left);
                return;
            }

            if (currentNode.left != null && currentNode.right != null) {

                // If left has already been visited.
                if (isVisited(currentNode.left)) {
                    visitNode(currentNode);
                    doInOrder(currentNode.right);
                    return;
                }

                // Else.
                visitLater(currentNode);
                doInOrder(currentNode.left);
                return;
            }
        }
        System.out.println(VISITED.toString());
    }

    private static boolean isVisited(Node node) {
        return VISITED.indexOf(node.data + " ") > -1;
    }

    private static void visitLater(Node node) {
        STACK.push(node);
    }

    private static void visitNode(Node node) {
        VISITED.append(node.data);
        VISITED.append(" ");
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
        inOrder(root);
    }

}
