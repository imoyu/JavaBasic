package com.fs.anonymous;

public class T4 {

    private String name;
    private String age;

    public T4(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public T4(String name) {
        this(name, "10");
    }

    private static void f1() { }
    private void f2() { }
    private void f3() {
        this.f2();
    }

    public static void main(String[] args) {
        T4.f1();
    }
}
