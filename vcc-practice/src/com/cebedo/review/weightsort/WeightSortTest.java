/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.review.weightsort;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class WeightSortTest {

    public static void main(String[] args) {
        new WeightSortTest().basicTests();
    }

    public void basicTests() {
        System.out.println("2000 103 123 4444 99".equals(WeightSort.orderWeight("103 123 4444 99 2000")));
        System.out.println((WeightSort.orderWeight("103 123 aaaaaaaaaaaaaaaaaaaaaaaaaa 99 2000")));
        // assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        // assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
