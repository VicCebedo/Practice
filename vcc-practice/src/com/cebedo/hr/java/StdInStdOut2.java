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

import java.util.Scanner;

/**
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class StdInStdOut2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputInt = Integer.parseInt(scanner.nextLine());
            double inputDouble = Double.parseDouble(scanner.nextLine());
            String inputString = scanner.nextLine();

            System.out.println("String: " + inputString);
            System.out.println("Double: " + inputDouble);
            System.out.println("Int: " + inputInt);
        }
    }
}
