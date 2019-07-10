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

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class LevelOrderTraversal {

    private static final LinkedList<Node> QUEUE = new LinkedList<>();
    private static final StringBuilder VISITED = new StringBuilder();

    public static void levelOrder(Node currentNode) {
        while (true) {
            if (!QUEUE.isEmpty()) {
                visitNode(currentNode);
                if (currentNode.left != null) {
                    QUEUE.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    QUEUE.add(currentNode.right);
                }
                levelOrder(QUEUE.pop());
                return;
            }

            if (currentNode.left == null && currentNode.right == null) {
                visitNode(currentNode);
                if (QUEUE.isEmpty()) {
                    break;
                } else {
                    levelOrder(QUEUE.pop());
                    return;
                }
            }

            if (currentNode.left == null && currentNode.right != null) {
                visitNode(currentNode);
                levelOrder(currentNode.right);
                return;
            }

            if (currentNode.left != null && currentNode.right == null) {
                visitNode(currentNode);
                levelOrder(currentNode.left);
                return;
            }

            if (currentNode.left != null && currentNode.right != null) {
                visitNode(currentNode);
                QUEUE.add(currentNode.right);
                levelOrder(currentNode.left);
                return;
            }
        }
        System.out.println(VISITED.toString());
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
        levelOrder(root);
    }
}
