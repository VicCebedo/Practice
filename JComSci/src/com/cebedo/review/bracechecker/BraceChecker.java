/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.review.bracechecker;

import java.util.Stack;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class BraceChecker {

    public static void main(String[] args) {
        System.out.print(new BraceChecker().isValid("([{}])"));
    }

    /**
     * Returns true if the given string contains an array of balanced brackets.
     *
     * @param braces String to be traversed.
     * @return True or false, depending if it is balanced or not.
     */
    public boolean isValid(String braces) {
        if (braces == null || braces.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char brace : braces.toCharArray()) {

            // If this is not even a bracket,
            // then this is an invalid input.
            if (!isValidBracket(brace)) {
                return false;
            }

            // If current bracket is open,
            // push to stack.
            if (isOpenBracket(brace)) {
                stack.push(brace);
            } else {

                // If we have ran out of characters to pop,
                // then this is not balanced.
                if (stack.isEmpty()) {
                    return false;
                }

                // If the current character is a closing bracket,
                // check if it matches with the current bracket.
                // If it does not, then this is not balanced.
                char open = stack.pop();
                if (!bracketMatches(open, brace)) {
                    return false;
                }
            }
        }

        // If we have finished traversing all characters
        // and there is still leftover character in stack,
        // then this is not balanced.
        return stack.isEmpty();
    }

    /**
     * Returns true if the provided character is a type of bracket.
     *
     * @param c Character to be checked.
     * @return True or false depending on given character.
     */
    private boolean isValidBracket(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}';
    }

    /**
     * Returns true if the given brackets matches with each other.
     *
     * @param open Open bracket character.
     * @param close Close bracket character.
     * @return True or false, depending on the provided characters.
     */
    private boolean bracketMatches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    /**
     * Returns true if the given character is an open bracket.
     *
     * @param c Character to be checked.
     * @return True or false, depending on given character.
     */
    private boolean isOpenBracket(char c) {
        switch (c) {
            case ')':
                return false;
            case ']':
                return false;
            case '}':
                return false;
            default:
                return true;
        }
    }
}
