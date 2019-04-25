/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.algorithms.implementation;

/**
 *
 * @author Vic Cebedo
 */
public class GradingStudents {

    static int[] gradingStudents(int[] grades) {
        // Constraints.
        if (grades.length > 60) {
            return grades;
        }

        // Loop through each element.
        // For each element, do a rounding, then save it back.
        for (int i = 0; i < grades.length; i++) {
            grades[i] = round(grades[i]);
        }

        return grades;
    }

    static int round(int grade) {
        // If grade is not in range,
        // or grade is failed.
        if (!(0 <= grade && grade <= 100) || grade < 38) {
            return grade;
        }

        // Get the first digit.
        int firstDigit = grade % 10;
        int roundedGrade = 0;
        if (firstDigit == 0 || firstDigit == 5) {
            roundedGrade = grade + 5;
        } else if (1 <= firstDigit && firstDigit <= 4) {
            roundedGrade = (int) (Math.ceil(grade / 10) * 10) + 5;
        } else {
            roundedGrade = (int) (Math.ceil(grade / 10) * 10) + 10;
        }
        return roundedGrade - grade < 3 ? roundedGrade : grade;
    }

    public static void main(String[] args) {
        System.out.print(round(38));
    }

}
