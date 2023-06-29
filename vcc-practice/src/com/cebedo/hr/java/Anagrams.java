/*
 * The MIT License
 *
 * Copyright 2023 vcebedo.
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
package com.cebedo.hr.java;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vcebedo
 */
public class Anagrams {

    static boolean isAnagram(String a, String b) {

        // If not equal length, not anagram.
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            Character character = a.charAt(i);

            // If map contains this character,
            // then +1 to count.
            if (map.containsKey(character)) {
                int count = map.get(character);
                map.put(character, count + 1);
            } else {
                map.put(character, 1);
            }
        }

        // Check if same count for each character exists in b string.
        for (int i = 0; i < b.length(); i++) {
            Character character = b.charAt(i);
            if (!map.containsKey(character)) {
                return false;
            }

            // Deduct 1 from count.
            int count = map.get(character);
            map.put(character, count - 1);
        }

        // At the end, all keys must have zero counts.
        for (int val : map.values()) {
            if (val > 0) {
                return false;
            }
        }

        return true;
    }
}
