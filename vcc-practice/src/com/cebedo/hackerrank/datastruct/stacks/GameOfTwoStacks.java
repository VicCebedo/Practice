/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.hackerrank.datastruct.stacks;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo
 */
public class GameOfTwoStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        int score = 0;
        int aIndex = 0;
        int bIndex = 0;

        // While we are not yet disqualified,
        // and both stacks are not yet empty.
        while (!isDisqualified(score, x)) {

            // Get the values on top of the stack.
            int aValue = a[aIndex];
            int bValue = b[bIndex];

            // If both are equal,
            // pop the one with lower 'next' value.
            if (aValue == bValue) {
                if (isFutureALesser(a, b, aIndex, bIndex)) {
                    if (isDisqualified(score + aValue, x)) {
                        break;
                    }
                    score += aValue;
                    aIndex++;
                } else {
                    if (isDisqualified(score + bValue, x)) {
                        break;
                    }
                    score += bValue;
                    bIndex++;
                }
            } else if (aValue < bValue) {

                // If we get disqualified by choosing a,
                // then the game is over.
                if (isDisqualified(score + aValue, x)) {
                    break;
                }
                score += aValue;
                aIndex++;
            } else {
                if (isDisqualified(score + bValue, x)) {
                    break;
                }
                score += bValue;
                bIndex++;
            }
        }

        return score;
    }

    static boolean isFutureALesser(int[] a, int[] b, int aIndex, int bIndex) {
        int indexA = aIndex;
        int indexB = bIndex;

        // Find first one with lower value.
        while (indexA < a.length && indexB < b.length) {
            int aValue = a[indexA];
            int bValue = b[indexB];

            // If both are equal, proceed to next.
            if (aValue == bValue) {
                indexA++;
                indexB++;
                continue;
            }
            return a[indexA] < b[indexB];
        }
        return false;
    }

    static boolean isDisqualified(int gameValue, int x) {
        return gameValue > x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(result);
        }
    }
}
