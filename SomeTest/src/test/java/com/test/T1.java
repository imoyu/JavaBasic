package com.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T1 {

    @Test
    public void test1() {
        int a;
        Integer b;
        int c = 1;
        Integer d = 2;
        Integer e = null;
        Random r = new Random();
        a = r.nextBoolean() ? c : d;
//        a = r.nextBoolean() ? c : e;   // false 报错
        b = r.nextBoolean() ? c : d;
//        b = r.nextBoolean() ? c : e;   // false 报错

        String s = "ds";

        switch (s) {
            case "a" :
                System.out.println(1);
                break;
            case "ds" :
                System.out.println(2);
                break;
            default:
                System.out.println("d");
        }

    }

    @Test
    public void testContinue() {

        Boolean f1 = true;
        Boolean f2 = true;
        Boolean f3 = true;

        for (int i = 0; i < 10; i++) {
            if (f1 != null) {
                if (f2 != null) {
                    if (f3) {
                        continue;
                    }
                }
            }
            System.out.println("=================>");
        }
        System.out.println(String.format("finish%d", 12L));
    }

    @Test
    public void testRegex() {
        Pattern pattern = Pattern.compile("[a-z]\\d");
        Matcher matcher = pattern.matcher("ess231r2gfd4f");

        // matcher使用matches()方法后就失效了，不能再使用find取值：
        System.out.println(matcher.matches());         // --> false

        matcher.find();
        System.out.println(matcher.group(0));      // --> s2   r2    d4

        Pattern p = Pattern.compile("p");
        Matcher m1 = p.matcher("P");
        System.out.println(m1.matches());
    }

    @Test
    public void testDate() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2020-12-12 大厦 12:01");
        System.out.println(date);// 不报错

        LocalDateTime localDate = LocalDateTime.parse("2020-12-12 12:01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate);// 报错
    }

    @Test
    public void testClass() {

        funClass(Date.class);

    }

    private static <T> void funClass(Class<T> clazz) {
        System.out.println(clazz.getName());
        System.out.println();
    }

    @Test
    public void test() {

        String year = null;
        String month = null;
        String day = null;
        String hour = null;
        String minute = null;

        Pattern p1 = Pattern.compile("\\d{4}");
        Pattern p2 = Pattern.compile("\\d{1,2}");
        String arrivalTime = "2019/12/3 12:22:45";
        Matcher m1 = p1.matcher(arrivalTime);
        if (m1.find()) {
            year = m1.group();
            arrivalTime = m1.replaceAll("");
        }
        Matcher m2 = p2.matcher(arrivalTime);
        int index = 0;
        while (m2.find()) {
            index ++;
            switch (index) {
                case 1:
                    month = m2.group();
                    break;
                case 2:
                    day = m2.group();
                    break;
                case 3:
                    hour = m2.group();
                    break;
                case 4:
                    minute = m2.group();
            }
        }
        if (year != null && (index == 2 || index == 4 || index == 5)) {
            System.out.printf("%s年%s月%s日%s时%s分%n", year, month, day, hour, minute);
        }

    }
}
