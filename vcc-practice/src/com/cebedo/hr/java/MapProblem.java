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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MapProblem {

    public static void main(String[] argh) {

        // Get the number of entries.
        Scanner scanner = new Scanner(System.in);
        int numberOfEntries = scanner.nextInt();
        scanner.nextLine();

        // Map the name to phone.
        Map<String, Integer> namePhoneMap = new HashMap<>();
        for (int i = 0; i < numberOfEntries; i++) {
            String name = scanner.nextLine();
            int phone = scanner.nextInt();
            scanner.nextLine();

            // Add to map.
            namePhoneMap.put(name, phone);
        }

        // Get user queries.
        while (scanner.hasNext()) {

            // Get value based on key.
            String key = scanner.nextLine();
            Object value = namePhoneMap.get(key);

            // If value cannot be found.
            if (value == null) {
                System.out.println("Not found");
            } else {

                // If found,
                // print to user.
                System.out.println(
                        String.format(
                                "%s=%s",
                                key,
                                value.toString()));
            }
        }
    }
}
