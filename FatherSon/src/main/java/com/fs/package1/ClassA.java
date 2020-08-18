package com.fs.package1;

public class ClassA {

    int a;
    protected int b;

    static void func() {}

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.fs.package1.ClassB");
    }
}
