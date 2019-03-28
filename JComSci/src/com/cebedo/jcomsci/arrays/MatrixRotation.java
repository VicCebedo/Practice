/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.jcomsci.arrays;

/**
 * Given an image represented by NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees.
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class MatrixRotation {

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        System.out.println(new MatrixRotation().rotate(matrix));
    }

    // TODO Optimize this.
    public char[][] rotate(char[][] matrix) {
        int len = matrix[0].length;
        char[][] newMatrix = new char[len][len];
        int newMatrixIndex = 0;

        for (int i = len - 1; i >= 0; i--) {
            char[] rotatedValue = new char[len];

            for (int j = 0; j < len; j++) {
                char currentValue = matrix[j][i];
                rotatedValue[j] = currentValue;
            }
            newMatrix[newMatrixIndex] = rotatedValue;
            newMatrixIndex++;
        }
        return newMatrix;
    }

}
