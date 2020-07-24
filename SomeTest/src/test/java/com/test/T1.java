package com.test;

import org.junit.Test;

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

//        matcher.find();
        System.out.println(matcher.group(0));      // --> s2   r2    d4
    }
}
