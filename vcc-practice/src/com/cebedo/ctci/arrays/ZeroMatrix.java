/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.ctci.arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 1, 4}, {0, 1, 2, 4}, {1, 1, 2, 2}};
        new ZeroMatrix().run(matrix);
    }

    public int[][] run(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        Integer[] zeroRows = new Integer[rowLength];
        Integer[] zeroColumns = new Integer[colLength];

        // Get the array of zero rows and zero columns.
        this.getZeroRowsAndCols(matrix, zeroRows, zeroColumns);

        // If this row exists in the target, set all to zero.
        for (int row = 0; row < rowLength; row++) {
            if (isExist(zeroRows, row)) {
                this.setToRowsZero(matrix, row);
            }
        }

        // If this column exists in target, set all to zero.
        for (int col = 0; col < colLength; col++) {
            if (isExist(zeroColumns, col)) {
                setToColumnsZero(matrix, col);
            }
        }
        return matrix;
    }

    private void setToColumnsZero(int[][] matrix, int col) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (j == col) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setToRowsZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) {
                matrix[i] = new int[matrix[0].length];
            }
        }
    }

    /**
     * Get the array of zero rows and zero columns.
     *
     * @param matrix
     * @param zeroRows
     * @param zeroColumns
     */
    private void getZeroRowsAndCols(int[][] matrix, Integer[] zeroRows, Integer[] zeroColumns) {
        int indexRows = 0;
        int indexColumns = 0;
        boolean firstRunRow = true;
        boolean firstRunCol = true;

        // Loop through each row.
        for (int i = 0; i < matrix.length; i++) {
            // If this row has been listed before, skip it.
            if (isExist(zeroRows, i) && !firstRunRow) {
                continue;
            }
            if (firstRunRow) {
                firstRunRow = false;
            }
            int[] currentRow = matrix[i];

            // Loop through each cell.
            for (int j = 0; j < currentRow.length; j++) {
                // If this column has been listed before, skip it.
                if (isExist(zeroColumns, j) && !firstRunCol) {
                    continue;
                }
                if (firstRunCol) {
                    firstRunCol = false;
                }
                int currentCell = currentRow[j];

                // If you find a zero,
                // take note of the row and column number.
                if (currentCell == 0) {
                    zeroRows[indexRows] = i;
                    zeroColumns[indexColumns] = j;
                    indexRows++;
                    indexColumns++;
                }
            }
            firstRunRow = true;
            firstRunCol = true;
        }
    }

    private boolean isExist(Integer[] arr, int toCheck) {
        for (Integer currentVal : arr) {
            if (currentVal == null) {
                continue;
            }
            if (currentVal == toCheck) {
                return true;
            }
        }
        return false;
    }

}
