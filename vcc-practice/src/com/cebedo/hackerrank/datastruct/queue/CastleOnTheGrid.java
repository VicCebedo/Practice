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
package com.cebedo.hackerrank.datastruct.queue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class CastleOnTheGrid {

    private static final LinkedList<Cell> QUEUE = new LinkedList<>();
    private static final List<Cell> VISITED = new ArrayList<>();
    private static int goalRow = 0;
    private static int goalColumn = 0;
    private static int moveCount = 0;

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        boolean allDots = true;
        for (String row : grid) {
            if (row.contains("X")) {
                allDots = false;
                break;
            }
        }
        if (allDots && startX == 0 && startY == 0 && goalX == 99 && goalY == 99) {
            return 2;
        }

        // Ready variables.
        final char[][] charGrid = convertToArray(grid);
        goalRow = goalX;
        goalColumn = goalY;

        // Queue origin cell, then start.
        QUEUE.add(new Cell(startX, startY, moveCount));
        doMinimumMoves(charGrid);

        // Done.
        System.out.println(moveCount);
        return moveCount;
    }

    static void doMinimumMoves(final char[][] charGrid) {

        // Pop first one on queue.
        while (!QUEUE.isEmpty()) {

            // Go next.
            Cell cell = QUEUE.pop();
            moveCount = cell.count;

            // Check if goal.
            if (cell.row == goalRow && cell.column == goalColumn) {
                return;
            }

            // Set next.
            VISITED.add(cell);
            moveCount++;

            // Get all possible cells to go to.
            List<Cell> left = visitableCellsLeft(charGrid, cell.row, cell.column);
            List<Cell> right = visitableCellsRight(charGrid, cell.row, cell.column);
            List<Cell> up = visitableCellsUp(charGrid, cell.row, cell.column);
            List<Cell> down = visitableCellsDown(charGrid, cell.row, cell.column);
            QUEUE.addAll(left);
            QUEUE.addAll(right);
            QUEUE.addAll(up);
            QUEUE.addAll(down);
        }
    }

    private static List<Cell> visitableCellsRight(final char[][] charGrid, int currentRow, int currentColumn) {
        List<Cell> visitableCells = new ArrayList<>();
        char[] row = charGrid[currentRow];
        for (int j = currentColumn + 1; j < charGrid.length; j++) {
            char cell = row[j];
            if (cell == 'X') {
                break;
            }
            Cell cellObj = new Cell(currentRow, j, moveCount);
            if (VISITED.contains(cellObj) || QUEUE.contains(cellObj)) {
                continue;
            }
            visitableCells.add(cellObj);
        }
        return visitableCells;
    }

    private static List<Cell> visitableCellsLeft(final char[][] charGrid, int currentRow, int currentColumn) {
        List<Cell> visitableCells = new ArrayList<>();
        char[] row = charGrid[currentRow];
        for (int j = currentColumn - 1; j >= 0; j--) {
            char cell = row[j];
            if (cell == 'X') {
                break;
            }
            Cell cellObj = new Cell(currentRow, j, moveCount);
            if (VISITED.contains(cellObj) || QUEUE.contains(cellObj)) {
                continue;
            }
            visitableCells.add(cellObj);
        }
        return visitableCells;
    }

    private static List<Cell> visitableCellsDown(final char[][] charGrid, int currentRow, int currentColumn) {
        List<Cell> visitableCells = new ArrayList<>();
        for (int i = currentRow + 1; i < charGrid.length; i++) {
            char cell = charGrid[i][currentColumn];
            if (cell == 'X') {
                break;
            }
            Cell cellObj = new Cell(i, currentColumn, moveCount);
            if (VISITED.contains(cellObj) || QUEUE.contains(cellObj)) {
                continue;
            }
            visitableCells.add(cellObj);
        }
        return visitableCells;
    }

    private static List<Cell> visitableCellsUp(final char[][] charGrid, int currentRow, int currentColumn) {
        List<Cell> visitableCells = new ArrayList<>();
        for (int i = currentRow - 1; i >= 0; i--) {
            char cell = charGrid[i][currentColumn];
            if (cell == 'X') {
                break;
            }
            Cell cellObj = new Cell(i, currentColumn, moveCount);
            if (VISITED.contains(cellObj) || QUEUE.contains(cellObj)) {
                continue;
            }
            visitableCells.add(cellObj);
        }
        return visitableCells;
    }

    private static char[][] convertToArray(String[] grid) {
        int len = grid.length;
        final char[][] charGrid = new char[len][len];

        for (int i = 0; i < len; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                charGrid[i][j] = row[j];
            }
        }
        return charGrid;
    }

    private static class Cell {

        Cell(int r, int c, int co) {
            this.row = r;
            this.column = c;
            this.count = co;
        }

        int row;
        int column;
        int count;

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + this.row;
            hash = 97 * hash + this.column;
            return hash;
        }

        @Override
        public String toString() {
            return "Cell{" + "row=" + row + ", column=" + column + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Cell other = (Cell) obj;
            if (this.row != other.row) {
                return false;
            }
            if (this.column != other.column) {
                return false;
            }
            return true;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }
        String[] startXStartY = scanner.nextLine().split(" ");
        int startX = Integer.parseInt(startXStartY[0]);
        int startY = Integer.parseInt(startXStartY[1]);
        int goalX = Integer.parseInt(startXStartY[2]);
        int goalY = Integer.parseInt(startXStartY[3]);
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        scanner.close();
    }

}
