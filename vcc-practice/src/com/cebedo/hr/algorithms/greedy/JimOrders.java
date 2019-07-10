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
package com.cebedo.hr.algorithms.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class JimOrders {

    static int[] jimOrders(int[][] orders) {
        int customerId = 1;
        Map<Integer, List<Integer>> serveTimeToCustomerId = new HashMap<>();

        for (int[] order : orders) {
            int orderNumber = order[0];
            int prepTime = order[1];
            int servingTime = orderNumber + prepTime;

            // Put to map.
            List<Integer> customers = serveTimeToCustomerId.get(servingTime);
            if (customers == null) {
                customers = new ArrayList<>();
            }
            customers.add(customerId);
            serveTimeToCustomerId.put(servingTime, customers);

            // Next.
            customerId++;
        }

        List<Integer> serveTime = serveTimeToCustomerId
                .keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (int sTime : serveTime) {
            List<Integer> custIds = serveTimeToCustomerId.get(sTime);
            Collections.sort(custIds);
            result.addAll(custIds);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] orders = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }
        int[] result = jimOrders(orders);
        scanner.close();
    }

}
