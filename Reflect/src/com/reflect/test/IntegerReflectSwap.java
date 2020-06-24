package com.reflect.test;

import java.lang.reflect.Field;

/**
 *
 */
public class IntegerReflectSwap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 2;
        Integer b = 3;

        swap(a, b);

        System.out.println(a);
        System.out.println(b);
    }

    private static void swap(int a, int b) throws NoSuchFieldException, IllegalAccessException {
        int temp = a;

        Class clazz = Integer.class;
        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        value.setInt(a, b);
        value.setInt(b, temp);
    }
}
