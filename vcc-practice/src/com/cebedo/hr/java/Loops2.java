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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Loops2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfQueries = Integer.parseInt(scanner.nextLine());
            List<String> queries = new ArrayList<>();

            // Get all the queries from the user.
            for (int x = 0; x < numberOfQueries; x++) {
                String query = scanner.nextLine();
                queries.add(query);
            }

            List<Double> answers = new ArrayList<>();
            List<String> equations = new ArrayList<>();
            for (String query : queries) {
                String[] querySplit = query.split(" ");
                int a = Integer.parseInt(querySplit[0]);
                int b = Integer.parseInt(querySplit[1]);
                int n = Integer.parseInt(querySplit[2]);

                for (int x = 0; x < n; x++) {
                    String equation = "";

                    // If initial equation.
                    if (x == 0) {
                        double answer = a + Math.pow(2, x) * b;
                        answers.add(answer);

                    } else {
                        // Succeeding equations.
                        String format = "+ %s * %s";
                        equation = String.format(format,
                                Math.pow(2, x),
                                b);
                        equation = equations.get(equations.size() - 1)
                                .concat(equation);
                    }

                    equations.add(equation);
                }
            }

            // Parse the queries, and get a, b and n.
            // Get all equations.
            /*
            List<String> equations = new ArrayList<>();
            for (String query : queries) {
                String[] querySplit = query.split(" ");
                int a = Integer.parseInt(querySplit[0]);
                int b = Integer.parseInt(querySplit[1]);
                int n = Integer.parseInt(querySplit[2]);

                for (int x = 0; x < n; x++) {
                    String equation = "";

                    // If initial equation.
                    if (x == 0) {
                        String format = "%s + %s * %s";
                        equation = String.format(format,
                                a,
                                Math.pow(2, x),
                                b);
                    } else {
                        // Succeeding equations.
                        String format = "+ %s * %s";
                        equation = String.format(format,
                                Math.pow(2, x),
                                b);
                        equation = equations.get(equations.size() - 1)
                                .concat(equation);
                    }

                    equations.add(equation);
                }
            }
             */
            /**
             * One possible reason for this could be that you don't have a
             * JavaScript engine implementation, such as Rhino or Nashorn,
             * included in your Java installation or classpath.
             *
             * Please note that starting from Java 11, the Nashorn JavaScript
             * engine is no longer included as part of the Java Development Kit
             * (JDK) by default. If you're using a newer version of Java, you
             * may need to use an external JavaScript engine library or consider
             * alternative approaches for evaluating math equation strings.
             *
             */
            // For each equation,
            // evaluate it and add to list.    
            /*
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            List<Integer> answers = new ArrayList<>();

            for (String equation : equations) {
                try {
                    Object result = engine.eval(equation);
                    int answer = Integer.parseInt(result.toString());
                    answers.add(answer);
                } catch (ScriptException ex) {
                    Logger.getLogger(Loops2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println(answers);
             */
        }
    }
}
