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
public class SimpleTextEditor {

    private static StringBuilder CURRENT_STRING = new StringBuilder();
    private static Stack<String> PREVIOUS_VERSIONS = new Stack<>();

    private static void processInput(String input) {

        String[] inputSplit = input.split(" ");
        String command = inputSplit[0];

        if (command.equals("1")) {
            PREVIOUS_VERSIONS.push(CURRENT_STRING.toString());
            append(inputSplit[1]);
            return;
        }

        if (command.equals("2")) {
            delete(inputSplit[1]);
            return;
        }

        if (command.equals("3")) {
            print(inputSplit[1]);
            return;
        }

        if (command.equals("4")) {
            String oldVersion = PREVIOUS_VERSIONS.pop();
            CURRENT_STRING = new StringBuilder(oldVersion);
        }
    }

    private static void delete(String s) {
        PREVIOUS_VERSIONS.push(CURRENT_STRING.toString());

        int k = Integer.parseInt(s);
        int start = CURRENT_STRING.length() - k;
        int end = CURRENT_STRING.length();
        CURRENT_STRING.delete(start, end);
    }

    private static void append(String s) {
        CURRENT_STRING.append(s);
    }

//    public static void main(String[] args) {
//        //1 abc
//        processInput("1 abc");
//        //3 3
//        processInput("3 3");
//        //2 3
//        processInput("2 3");
//        //1 xy
//        processInput("1 xy");
//        //3 2
//        processInput("3 2");
//        //4 
//        processInput("4");
//        //4 
//        processInput("4");
//        //3 1
//        processInput("3 1");
//    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                processInput(input);
            }
        }
    }

    private static void print(String s) {
        int k = Integer.parseInt(s);
        System.out.println(CURRENT_STRING.charAt(k - 1));
    }
}
