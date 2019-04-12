/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.review.weightsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class WeightSort {

    public static void main(String[] args) {
        System.out.println("****** Basic Tests ******");
//        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));

//        System.out.println(orderWeight("56 65 74 100 99 68 86 180 90"));
        System.out.println(orderWeight("59544965313 11 22 123"));
    }

    /**
     * Return a list of numbers in ascending order by weight, as a string joined
     * by a space.
     *
     * @param strng String of digits to be summed and put in order.
     * @return A string of digits ordered by their "weight".
     */
    public static String orderWeight(String strng) {
        // Parse the given string.
        long[] inputNums = parseString(strng);

        // For each number, calculate the weight.
        // Then map them together with the input number.
        Map<Integer, List<Long>> weightMap = new HashMap<>();
        for (long num : inputNums) {

            int weight = weight(num);
            List<Long> inputsWithSameWeight = weightMap.get(weight);

            // If we do not have a similar weight against other inputs,
            // just create a new list and push.
            // If this weight already exists, then add to the list.
            if (inputsWithSameWeight == null) {
                inputsWithSameWeight = new ArrayList<>();
                inputsWithSameWeight.add(num);
            } else {
                inputsWithSameWeight.add(num);
            }
            weightMap.put(weight, inputsWithSameWeight);
        }

        // Sort the integers according to weight.
        // Join them together in a string before returning.
        long[] sorted = sortByWeight(weightMap, inputNums.length);
        return joinNumbers(sorted);
    }

    /**
     * Returns the sorted array of given numbers in ascending order (by weight).
     *
     * @param numbers Numbers that will be sorted.
     * @return Sorted array of numbers.
     */
    private static long[] sortByWeight(Map<Integer, List<Long>> map, int length) {
        // Get all the keys (which are the weights) of the map,
        // then sort them ascending.
        List<Integer> weights = new ArrayList<>(map.keySet());
        Collections.sort(weights);

        // Since we have the weights sorted already,
        // we can get the value for each weight in the correct order.
        long[] sortedByWeight = new long[length];
        int sortedIndex = 0;
        for (int weight : weights) {
            List<Long> inputs = map.get(weight);

            // If we have inputs that have the same weight,
            // sort inputs as string.
            // then push them to our final array.
            if (inputs.size() > 1) {
                List<String> numbersAsStrings = convertToStrings(inputs);
                Collections.sort(numbersAsStrings);
                for (String input : numbersAsStrings) {
                    sortedByWeight[sortedIndex] = Integer.parseInt(input);
                    sortedIndex++;
                }
            } else {
                sortedByWeight[sortedIndex] = map.get(weight).get(0);
                sortedIndex++;
            }
        }
        return sortedByWeight;
    }

    /**
     * Parse the string into an array of integers.
     *
     * @param string Given string to be parsed.
     * @return Parsed array of integers.
     */
    private static long[] parseString(String string) {
        // Initial check for input validity.
        if (string == null || string.isEmpty()) {
            return new long[0];
        }

        String[] numStrings = string.split(" ");
        long[] nums = new long[numStrings.length];
        int numIndex = 0;

        // Iterate through each number string,
        for (String numStr : numStrings) {

            // Check if it is a valid number,
            // parse it to integer.
            if (isValidNumber(numStr)) {
                nums[numIndex] = Long.parseLong(numStr);
                numIndex++;
            }
        }
        return nums;
    }

    /**
     * Returns true if the given number is a positive integer.
     *
     * @param numStr Number to be checked.
     * @return True or false, if number is a positive integer.
     */
    private static boolean isValidNumber(String numStr) {
        if (numStr == null || numStr.isEmpty()) {
            return false;
        }

        // Go through each character in string.
        for (int i = 0; i < numStr.length(); i++) {

            // Negative number is not a valid input.
            // Anything other than a positive integer is not accepted.
            if (!Character.isDigit(numStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the weight (sum of digits) of a number.
     *
     * @param num Number that will be processed.
     * @return Weight of the given number.
     */
    private static int weight(long num) {
        int sum = 0;
        for (long digit : digits(num)) {
            sum += digit;
        }
        return sum;
    }

    /**
     * Returns the array of digits of a number.
     *
     * @param num Number that will be processed.
     * @return Array of digits of the number.
     */
    private static long[] digits(long num) {
        // Get the length of the number,
        // declare a new array of length.
        int length = String.valueOf(num).length();
        long[] digits = new long[length];
        int digitIndex = 0;

        // Push each digit to array.
        while (num > 0) {
            digits[digitIndex] = (num % 10);
            num = num / 10;
            digitIndex++;
        }
        return digits;
    }

    /**
     * Returns a space-separated string of numbers.
     *
     * @param numbers Array of numbers that will be joined together.
     * @return Joined numbers as a string.
     */
    private static String joinNumbers(long[] numbers) {
        if (numbers.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (long num : numbers) {
            sb.append(num);
            sb.append(" ");
        }

        // Remove the extra space.
        // Then return the joined numbers.
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * Returns a list of strings given a list of numbers.
     *
     * @param numbers Numbers to be converted.
     * @return List of numbers as a string.
     */
    private static List<String> convertToStrings(List<Long> numbers) {
        List<String> strings = new ArrayList<>();
        for (long num : numbers) {
            strings.add(String.valueOf(num));
        }
        return strings;
    }

}
