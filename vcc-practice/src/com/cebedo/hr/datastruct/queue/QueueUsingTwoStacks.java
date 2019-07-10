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
package com.cebedo.hr.datastruct.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class QueueUsingTwoStacks {

    private static final Stack<Integer> STACK_1 = new Stack<>();
    private static final Stack<Integer> STACK_2 = new Stack<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                processInput(input);
            }
        }
    }

    static void processInput(String input) {
        String[] inputs = input.split(" ");
        switch (inputs[0]) {
            case "1": {
                enqueue(Integer.parseInt(inputs[1]));
                break;
            }
            case "2": {
                dequeue();
                break;
            }
            case "3": {
                print();
                break;
            }
            default: {
                break;
            }
        }
    }

    static void enqueue(int num) {
        STACK_1.push(num);
    }

    static void dequeue() {
        // If second stack is empty,
        // transfer all.
        if (STACK_2.isEmpty()) {
            while (!STACK_1.isEmpty()) {
                STACK_2.push(STACK_1.pop());
            }
        }
        STACK_2.pop();
    }

    static void print() {
        if (STACK_2.isEmpty()) {
            while (!STACK_1.isEmpty()) {
                STACK_2.push(STACK_1.pop());
            }
        }
        System.out.println(STACK_2.peek());
    }
}
