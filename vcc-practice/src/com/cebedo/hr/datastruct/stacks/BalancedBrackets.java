/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hr.datastruct.stacks;

import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.print(isBalanced("((()))[]{[(()({[()({[]}{})]}))]}{[]}{{({}{})[{}{}]{()([()])[{()}()[[]{}()]{}{}[]()]}[[]{[]}([])]}}"));
    }

    static String isBalanced(String s) {
        return isBal(s) ? "YES" : "NO";
    }

    private static boolean isBal(String s) {
        // If the given is an odd, or null.
        if (s == null || (s.length() % 2) > 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // For each character, check if it is a closing bracket or not.
            // If open bracket, add to stack.
            if (isOpenBracket(c)) {
                addToStack(stack, c);
            } else {

                // Else, must match with latest in stack.
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isOpenBracket(char c) {
        switch (c) {
            case ')':
                return false;
            case ']':
                return false;
            case '}':
                return false;
            default:
        }
        return true;
    }

    static void addToStack(Stack<Character> stack, char c) {
        switch (c) {
            case '(':
                stack.add(')');
                break;
            case '[':
                stack.add(']');
                break;
            case '{':
                stack.add('}');
                break;
            default:
        }
    }
}
