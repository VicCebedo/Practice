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
package com.cebedo.hackerrank.datastruct.trees;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class PostOrderTraversal {

    private static final StringBuilder VISITED = new StringBuilder();
    private static final Stack<Node> TO_VISIT = new Stack<>();

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        TO_VISIT.push(root);
        doPostOrder(root);
    }

    private static void doPostOrder(Node root) {
        // Do loop while we have not yet reached a deadend on the left side.
        // Add to stack along the way.
        while (!TO_VISIT.isEmpty()) {
            if (root.left == null && root.right == null) {

                // Visit now, proceed to next in stack.
                visitNow(root);
                doPostOrder(TO_VISIT.pop());
                return;
            } else {

                // If two children are already visited,
                // pop from stack.
                if (childrenVisited(root)) {
                    visitNow(root);

                    if (TO_VISIT.peek().data == root.data
                            && TO_VISIT.size() == 1) {
                        break;
                    }
                    doPostOrder(TO_VISIT.pop());
                    return;
                } else {

                    // If left is null, right is not.
                    if (root.left == null && root.right != null) {
                        visitLater(root);
                        doPostOrder(root.right);
                        return;
                    } else if (root.left != null && root.right == null) {
                        // If right is null, left is not.
                        visitLater(root);
                        doPostOrder(root.left);
                        return;
                    } else {
                        // If both children are present.
                        visitLater(root);
                        visitLater(root.right);
                        doPostOrder(root.left);
                        return;
                    }
                }
            }
        }
        System.out.print(VISITED.toString());
    }

    private static boolean childrenVisited(Node node) {
        return (node.left == null || VISITED.indexOf(node.left.data + " ") > -1)
                && (node.right == null || VISITED.indexOf(node.right.data + " ") > -1);
    }

    private static void visitLater(Node node) {
        TO_VISIT.push(node);
    }

    private static void visitNow(Node node) {
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
        postOrder(root);
    }

}
