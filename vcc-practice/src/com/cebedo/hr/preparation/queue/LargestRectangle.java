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
package com.cebedo.hr.preparation.queue;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class LargestRectangle {

    private static long MAX_AREA = Long.MIN_VALUE;

    static long largestRectangle(int[] h) {

        int i = 0;

        while (i < h.length) {

            // Calculate area alone.
            // Current building only, without neighbors.
            // Assign to area, if greater.
            int buildingCount = 1;
            long leastBuilding = h[i];
            long currentArea = leastBuilding * buildingCount;
            if (currentArea > MAX_AREA) {
                MAX_AREA = currentArea;
            }

            // Traverse neighbors, break if lesser area is found.
            int j = 1;
            while (i + j < h.length) {
                leastBuilding = leastBuilding < h[i + j]
                        ? leastBuilding
                        : h[i + j];
                buildingCount++;

                long nextArea = buildingCount * leastBuilding;
                if (nextArea < currentArea) {
                    break;
                }
                currentArea = nextArea;
                if (currentArea > MAX_AREA) {
                    MAX_AREA = currentArea;
                }

                j++;
            }

            i++;
        }

        return MAX_AREA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] h = new int[n];
        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }
        long result = largestRectangle(h);
        scanner.close();
    }

}
