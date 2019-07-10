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
package com.cebedo.hr.preparation.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
public class LuckBalance {

    static int luckBalance(int maxWin, int[][] contests) {

        List<Integer> importants = new ArrayList<>();
        List<Integer> notImportants = new ArrayList<>();

        for (int[] contest : contests) {
            int luck = contest[0];
            boolean important = contest[1] == 1;
            if (important) {
                importants.add(luck);
            } else {
                notImportants.add(luck);
            }
        }

        Collections.sort(importants);
        Collections.sort(notImportants);

        int balance = 0;
        int winCount = 0;
        int notImportantIndex = notImportants.size() - 1;

        for (int i = importants.size() - 1; i >= 0; i--) {
            int importantValue = importants.get(i);

            // Secure the wins first,
            // then we can lose all remaining contests.
            if (winCount < maxWin) {
                balance += importantValue;
                winCount++;
            } else {

                // Lose the important contest,
                // win the not important.
                int notImportantValue = notImportantIndex >= 0
                        ? notImportants.get(notImportantIndex)
                        : Integer.MIN_VALUE;
                if (notImportantValue > importantValue) {

                    // If not important value is greater than the important one,
                    // then prioritize the not important, then lose on the important.
                    balance += notImportantValue;
                    balance -= importantValue;
                    notImportantIndex--;
                } else {
                    balance -= importantValue;
                }
            }
        }

        // If we have ran out of important ones,
        // then proceed to winning not important constests.
        while (notImportantIndex >= 0) {
            balance += notImportants.get(notImportantIndex);;
            notImportantIndex--;
        }

        return balance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] contests = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }
        int result = luckBalance(k, contests);
        scanner.close();
    }

}
