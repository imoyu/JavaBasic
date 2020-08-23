package com.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectTest {

    public static void main(String[] args) throws Exception {
//        methodTest();
//        constructorTest();
        fieldTest();
    }

    private static void methodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<MethodClass> clazz = MethodClass.class;

        Method[] methods = clazz.getMethods();
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);

        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        Object invoke = add.invoke(clazz.newInstance(), 3, 4);
        System.out.println(invoke);

        Method wait = clazz.getMethod("wait");
        System.out.println(wait);

//        Method wait1 = clazz.getDeclaredMethod("wait"); // java.lang.NoSuchMethodException

    }

    private static void constructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<MethodClass> clazz = MethodClass.class;

        Constructor<MethodClass> constructor = clazz.getConstructor(String.class);
        MethodClass methodClass = constructor.newInstance("");
    }

    private static void fieldTest() throws Exception{
        Class<MethodClass> clazz = MethodClass.class;
        Field f2 = clazz.getDeclaredField("f2");
        f2.setAccessible(true);
        MethodClass methodClass = new MethodClass();
        int i = (int) f2.get(methodClass);
        System.out.println(i);
        f2.set(methodClass, 11);
    }
}

class MethodClass {

    public final int f1 = 3;
    private int f2 = 2;

    public MethodClass() {
    }

    public MethodClass(String arg) {
        System.out.println("使用有参构造器 ---");
    }

    private int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a + b;
    }
}
