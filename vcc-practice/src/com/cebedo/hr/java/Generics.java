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

import java.lang.reflect.Method;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
class Printer {

    /**
     * Given a generic array, print each element.
     *
     * @param <T>
     * @param array Generic array.
     */
    <T> void printArray(T[] array) {
        for (T elem : array) {
            System.out.println(elem.toString());
        }
    }
}

public class Generics {

    public static void main(String args[]) {
        // Set inputs.
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        // Run the printer.
        Printer myPrinter = new Printer();
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        // Get all the methods of the Printer class.
        for (Method method : Printer.class.getDeclaredMethods()) {

            // Count the method named printArray.
            String name = method.getName();
            if (name.equals("printArray")) {
                count++;
            }
        }

        // If method is overloaded, fail.
        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }

    }

}
