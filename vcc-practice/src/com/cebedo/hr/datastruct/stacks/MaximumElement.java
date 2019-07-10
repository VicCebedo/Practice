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
package com.cebedo.hr.datastruct.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MaximumElement {

    private static final Stack<Integer> STACK = new Stack();
    private static final int QUERY_PUSH = 1;
    private static final int QUERY_DELETE_TOP = 2;
    private static final int QUERY_PRINT_MAX = 3;

    private static int MAX = Integer.MIN_VALUE;
    private static Stack<Integer> pastMax = new Stack<>();

    private static void handleQuery(int query, int data) {
        switch (query) {
            case QUERY_PUSH: {
                STACK.push(data);
                if (data > MAX) {
                    if (MAX != Integer.MIN_VALUE) {
                        pastMax.push(MAX);
                    }
                    MAX = data;
                }
                break;
            }
            case QUERY_DELETE_TOP: {
                if (!STACK.isEmpty()) {
                    if (STACK.pop() == MAX) {
                        MAX = pastMax.isEmpty()
                                ? Integer.MIN_VALUE
                                : pastMax.pop();
                    }
                }
                break;
            }
            case QUERY_PRINT_MAX: {
                System.out.println(MAX);
                break;
            }
            default: {
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] inputs = input.split(" ");

                int query = Integer.parseInt(inputs[0]);
                int data = 0;

                if (query == QUERY_PUSH && inputs.length == 2) {
                    data = Integer.parseInt(inputs[1]);
                }
                handleQuery(query, data);
            }
        }
    }

}
