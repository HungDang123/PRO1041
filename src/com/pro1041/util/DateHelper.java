/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pro1041.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String toString(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static int calculateAge(int birthYear, int birthMonth, int birthDay) {
        birthMonth++;
        birthYear = birthYear + 1900;
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        System.out.println(period.getYears());
        return period.getYears();
    }

    public static Date toDate(String dateString, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
    }

    public static Date now() {
        return new Date();
    }

    public static Date add(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static void main(String[] args) throws ParseException {
        String originalDateString = "Sat Nov 04 13:05:54 ICT 2023";
        Date date = toDate(originalDateString, "EEE MMM dd HH:mm:ss zzz yyyy");
        System.out.println(date);
        String formattedDate = toString(date, "yyyy-MM-dd");
        System.out.println(formattedDate);
    }

}
