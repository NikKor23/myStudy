package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        int day = 6;
        int month = 5;
        int year = 1996;
        int thisyear = 2020;

        GregorianCalendar calendar = new GregorianCalendar(year, month,  day);
        SimpleDateFormat format = new SimpleDateFormat("MM.dd.YYYY");
        for  ( int i = 0; i <= (thisyear - year); i++ ) {
           String str = calendar.getTime().toString();
            System.out.println(i + " - " + format.format(calendar.getTime()) + " - " + str.substring(0,3));
            calendar.add(calendar.YEAR, 1);
        }

    }
}
