package com.iorib.test;

import com.iorib.pojo.User;
import com.iorib.processor.ValueInjectFactory;

import java.lang.reflect.InvocationTargetException;

public class ValueInjectTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User user = ValueInjectFactory.getUserWithValue();
        System.out.println(user);
    }

}
