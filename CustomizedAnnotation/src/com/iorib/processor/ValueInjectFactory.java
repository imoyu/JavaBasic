package com.iorib.processor;

import com.iorib.anno.Value;
import com.iorib.pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ValueInjectFactory {

    public static User getUserWithValue() throws IllegalAccessException, InvocationTargetException {

        User user = new User();

        // Field 注入
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Value.class)) {
                Value value = field.getAnnotation(Value.class);
                if (field.getType().equals(Integer.class)) {
                    field.setInt(user, Integer.parseInt(value.value()));
                } else if (field.getType().equals(String.class)) {
                    field.set(user, value.value());
                }
            }
        }

        // Method 注入
        Method[] methods = User.class.getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(Value.class)) {
                System.out.println(method.getName());
                Value value = method.getAnnotation(Value.class);
                if (method.getParameterTypes()[0].equals(Integer.class)) {
                    method.invoke(user, Integer.parseInt(value.value()));
                } else if (method.getParameterTypes()[0].equals(String.class)) {
                    method.invoke(user, value.value());
                }

            }
        }


        return user;
    }

}
