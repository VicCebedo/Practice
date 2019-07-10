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

import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class EqualStacks {

    private static int[] HEIGHTS = new int[3];

    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        // If any of the input is zero,
        // then max height is zero.
        if (h1.length == 0 || h2.length == 0 || h3.length == 0) {
            return 0;
        }

        // Prepare stacks.
        Stack<Integer>[] stacks = arrayOfStacks(h1, h2, h3);
        calculateStackHeights(stacks);

        while (true) {
            // If all stacks equal, then return.
            if (allStacksEqual()) {
                return HEIGHTS[0];
            }

            // Pop from highest, recalculate its total.
            int indexOfHighestStack = indexOfHighestStack();
            int popped = stacks[indexOfHighestStack].pop();
            recalcHeights(indexOfHighestStack, popped);
        }
    }

    static void recalcHeights(int index, int value) {
        HEIGHTS[index] = HEIGHTS[index] - value;
    }

    static boolean allStacksEqual() {
        return HEIGHTS[0] == HEIGHTS[1] && HEIGHTS[1] == HEIGHTS[2];
    }

    static int indexOfHighestStack() {
        int maxIndex = 0;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < HEIGHTS.length; i++) {
            if (HEIGHTS[i] > maxHeight) {
                maxHeight = HEIGHTS[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void calculateStackHeights(Stack<Integer>[] stacks) {
        for (int i = 0; i < stacks.length; i++) {
            HEIGHTS[i] = sumOfElements(stacks[i]);
        }
    }

    static int sumOfElements(Stack<Integer> stack) {
        int sum = 0;
        for (Object elem : stack.toArray()) {
            sum += (int) elem;
        }
        return sum;
    }

    /**
     *
     * @param h1
     * @param h2
     * @param h3
     * @return
     */
    static Stack<Integer>[] arrayOfStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> h1Stack = convertToStack(h1);
        Stack<Integer> h2Stack = convertToStack(h2);
        Stack<Integer> h3Stack = convertToStack(h3);
        Stack<Integer>[] stacks = new Stack[3];
        stacks[0] = h1Stack;
        stacks[1] = h2Stack;
        stacks[2] = h3Stack;
        return stacks;
    }

    static Stack<Integer> convertToStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackReversed = new Stack<>();
        for (int elem : arr) {
            stack.push(elem);
        }
        while (!stack.isEmpty()) {
            stackReversed.push(stack.pop());
        }
        return stackReversed;
    }

//    public static void main(String[] args) {
//        int[] h1 = {3, 2, 1, 1, 1};
//        int[] h2 = {4, 3, 2};
//        int[] h3 = {1, 1, 4, 1};
//        int result = equalStacks(h1, h2, h3);
//        System.out.println(result);
//    }
}
