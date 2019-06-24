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
package com.cebedo.hackerrank.algorithms.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class GridChallenge {

    static String gridChallenge(String[] grid) {
        char[][] sortedGrid = new char[grid.length][grid[0].length()];

        // Transfer to primitive storage.
        int rowIndex = 0;
        for (String rowStr : grid) {
            sortedGrid[rowIndex] = rowStr.toCharArray();
            Arrays.sort(sortedGrid[rowIndex]);
            rowIndex++;
        }

        // Get data from top to down.
        int currentCol = 0;
        while (currentCol < sortedGrid[0].length) {
            char[] column = column(sortedGrid, currentCol);

            // Check if this column is sorted.
            if (!isSorted(column)) {
                return "NO";
            }
            currentCol++;
        }

        return "YES";
    }

    private static boolean isSorted(char[] column) {
        int current = 0;
        int next = current + 1;
        while (next < column.length) {
            if (column[current] > column[next]) {
                return false;
            }
            current++;
            next++;
        }
        return true;
    }

    private static char[] column(char[][] sortedGrid, int index) {
        // Height of the grid.
        char[] returnArray = new char[sortedGrid.length];

        int currentRow = 0;
        while (currentRow < sortedGrid.length) {
            returnArray[currentRow] = sortedGrid[currentRow][index];
            currentRow++;
        }
        return returnArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }
            String result = gridChallenge(grid);
        }
        scanner.close();
    }

}
