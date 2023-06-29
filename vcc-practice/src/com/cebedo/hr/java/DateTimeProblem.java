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

import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author vcebedo
 */
public class DateTimeProblem {

    public static String findDay(int month, int day, int year) {

        // Set the calendar instance.
        // And get the day of the week.
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        // Check if what day is it.
        String dayName = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                dayName = "SUNDAY";
                break;
            case Calendar.MONDAY:
                dayName = "MONDAY";
                break;
            case Calendar.TUESDAY:
                dayName = "TUESDAY";
                break;
            case Calendar.WEDNESDAY:
                dayName = "WEDNESDAY";
                break;
            case Calendar.THURSDAY:
                dayName = "THURSDAY";
                break;
            case Calendar.FRIDAY:
                dayName = "FRIDAY";
                break;
            case Calendar.SATURDAY:
                dayName = "SATURDAY";
                break;
            default:
                throw new AssertionError();
        }

        return dayName;
    }

    public static void main(String[] args) throws IOException {
        int month = 8;
        int day = 5;
        int year = 2015;
        String res = findDay(month, day, year);
    }
}
