/*
 * The MIT License
 *
 * Copyright 2023 Vic Cebedo <cebedo.vii@gmail.com>.
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
package com.cebedo.hr.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class OutputFormatting {

    public static void main(String[] args) {

        List<String> inputs = new ArrayList<>();

        // Get user inputs.
        try (Scanner scanner = new Scanner(System.in)) {
            for (int x = 0; x < 3; x++) {
                inputs.add(scanner.nextLine());
            }
        }

        // Print the answers.
        System.out.println("================================");
        for (String input : inputs) {

            String[] rawInput = input.split(" ");
            String inputString = rawInput[0];
            int inputInt = Integer.parseInt(rawInput[1]);

            // Get the length of the input.
            // Check first if index is pointing to existing character.
            // Else, print space.
            for (int y = 0; y < 15; y++) {
                int length = inputString.length();
                System.out.print(y < length
                        ? inputString.charAt(y)
                        : " ");
            }

            if (inputInt < 10) {
                System.out.println("00" + inputInt);
            } else if (inputInt < 100) {
                System.out.println("0" + inputInt);
            } else {
                System.out.println(inputInt);
            }
        }
        System.out.println("================================");
    }
}
