/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.review.sumofmultiples;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class Challenge {

    public static void main(String[] args) {
        System.out.println(Challenge.solution(-1));
    }

    /**
     * Returns the sum of all the multiples of 3 or 5 less than the number
     * passed.
     *
     * @param number Max number.
     * @return Sum of all multiples of 3 or 5.
     */
    public static Integer solution(Integer number) {
        return sumOfMultiples(number, 0, 0);
    }

    /**
     * Returns the sum of all natural numbers that are multiples of 3 or 5.
     *
     * @param maxNumber Max number to run function to.
     * @param num Natural number count start.
     * @param sum Recursive sum of natural numbers.
     * @return Sum of all multiples of 3 or 5.
     */
    private static int sumOfMultiples(Integer maxNumber, int num, int sum) {
        if (maxNumber == null || maxNumber <= 0) {
            return 0;
        }

        // If this number is a multiple of 3 OR 5,
        // AND this number is less than the provided max,
        // then add it to sum.
        if ((isMultiple(num, 3) || isMultiple(num, 5))
                && (num < maxNumber)) {
            sum += num;
        }

        // While we have not yet reached the max number,
        // continue counting.
        if (num < maxNumber) {
            return sumOfMultiples(maxNumber, num + 1, sum);
        }
        return sum;
    }

    /**
     * Return true if the given number is a multiple of the divisor.
     *
     * @param num Number to check.
     * @param divisor Divisor to check the number against.
     * @return True or false, depending if it is a multiple.
     */
    private static boolean isMultiple(int num, int divisor) {
        if (divisor == 0) {
            return false;
        }
        return (num % divisor) == 0;
    }
}
