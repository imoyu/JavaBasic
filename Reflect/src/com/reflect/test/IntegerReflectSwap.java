package com.reflect.test;

import java.lang.reflect.Field;

/**
 *
 */
public class IntegerReflectSwap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 200;
        Integer b = 300;
        swapReflect(a, b);
        System.out.println(a);
        System.out.println(b);

        int x = 4;
        int y = 5;
        swapReflect(x,y);
        System.out.println(x);
        System.out.println(y);
    }

    private static void swapReflect(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        int temp = a;
        Class<Integer> clazz = Integer.class;
        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        value.setInt(a, b);
        value.setInt(b, temp);
    }

}
