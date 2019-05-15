/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.stacks;

import java.util.Stack;

/**
 *
 * @author Vic Cebedo
 */
public class GameOfTwoStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        Stack<Integer> stackA = convertToStack(a);
        Stack<Integer> stackB = convertToStack(b);
        int popCount = 0;
        int sum = 0;

        while ((!stackA.isEmpty() || !stackB.isEmpty()) && sum < x) {
            int peekA = stackA.isEmpty()
                    ? Integer.MAX_VALUE
                    : stackA.peek();
            int peekB = stackB.isEmpty()
                    ? Integer.MAX_VALUE
                    : stackB.peek();

            if (peekA > peekB) {
                stackA.pop();
                sum += peekA;
            } else {
                stackB.pop();
                sum += peekB;
            }
            popCount++;
        }

        System.out.println(sum);
        return popCount;
    }

    static Stack<Integer> convertToStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        return stack;
    }

}
