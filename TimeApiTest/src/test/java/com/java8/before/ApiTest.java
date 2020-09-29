package com.java8.before;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApiTest {

    @Test
    public void dateTest() {
        Date date = new Date(); // 2020-09-27 14:43:38

        System.out.println(date.toString());

        int dates = date.getDate();
        System.out.println(dates);

        int year = date.getYear();
        System.out.println(year);

        int month = date.getMonth();
        System.out.println(month);

        int day = date.getDay();
        System.out.println(day);

        int hours = date.getHours();
        System.out.println(hours);

        int minutes = date.getMinutes();
        System.out.println(minutes);

        int seconds = date.getSeconds();
        System.out.println(seconds);

        long time = date.getTime();
        System.out.println(time);

        int offset = date.getTimezoneOffset();
        System.out.println(offset);

        System.out.println(new Date(0).getYear());
    }

    @Test
    public void StringToDateTest() {

        SimpleDateFormat ft = new SimpleDateFormat("yyyyy-MM-dd HH:mm:ss");

        try {
            System.out.println(ft.parse("2019-2-21"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void CalendarTest() {

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();
        System.out.println(date);

        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH)+1;

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        int minute = calendar.get(Calendar.MINUTE);

        int seconds = calendar.get(Calendar.SECOND);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.add(Calendar.HOUR, 10);

    }
}
