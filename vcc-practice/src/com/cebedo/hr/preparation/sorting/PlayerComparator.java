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
package com.cebedo.hr.preparation.sorting;

import java.util.Comparator;

/**
 *
 * @author Vic Cebedo <cebedo.vii@gmail.com>
 */
class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {

        int aScore = a.score;
        int bScore = b.score;

        if (aScore == bScore) {
            char[] aName = a.name.toCharArray();
            char[] bName = b.name.toCharArray();

            // In a scenario where:  a = "abcd", b = "abcdefg",
            // whichever name that has less length will be sorted first.
            int defaultLesser = -1;

            int minLen = 0;
            if (aName.length < bName.length) {
                minLen = aName.length;
            } else {
                minLen = bName.length;
                defaultLesser = 1;
            }

            // Loop through the min length,
            // and if the loop is finished but we were not able to return,
            // meaning all characters so far were equal,
            // then return the default, meaning return whichever name has
            // lesser length.
            int i = 0;
            while (i < minLen) {
                if (aName[i] < bName[i]) {
                    return -1;
                }
                if (aName[i] > bName[i]) {
                    return 1;
                }
                i++;
            }
            return defaultLesser;
        }

        if (aScore < bScore) {
            return 1;
        }
        return -1;
    }

}
