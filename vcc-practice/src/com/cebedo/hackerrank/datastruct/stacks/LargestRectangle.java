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
package com.cebedo.hackerrank.datastruct.stacks;

import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class LargestRectangle {

    private static long AREA = Long.MIN_VALUE;

    static long largestRectangle(int[] h) {
        int index = 0;
        while (index < h.length) {
            // Calculate alone.
            int width = 1;
            int currentHeight = h[index];
            updateHeight(currentHeight, width);

            // Proceed to neighbors.
            int nextHeight = h[index + 1];
            if (nextHeight >= currentHeight) {
                int start = index;
                int minHeight = currentHeight;
                width = getWidth(h, minHeight, start) + 1;
            } else {
                int start = index + 1;
                int minHeight = nextHeight;
                width = getWidth(h, minHeight, start);
            }

            // Next.
            index++;
        }
        return AREA;
    }

    static int getWidth(int[] h, int minHeight, int start) {
        int currentIndex = start;
        while (minHeight <= h[currentIndex] && currentIndex < h.length) {
            currentIndex++;
        }
        return currentIndex;
    }

    static void updateHeight(long h, int width) {
        long temp = h * width;
        if (temp > AREA) {
            AREA = temp;
        }
    }

    static Stack<Integer> convertToStack(int[] h) {
        Stack<Integer> stack = new Stack<>();
        for (int elem : h) {
            stack.push(elem);
        }
        return stack;
    }

}
