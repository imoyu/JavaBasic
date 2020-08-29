package com.fs.package3;

public class interfaceDefaultMethodTest {

    public static void main(String[] args) {
        new Son().dfunc();
    }

}

interface A {

    void func();

//    default void dfunc() {
//        System.out.println("default method in A");
//    }

    static void sfunc() {}
}
interface B {

    String func(int i);

    default void dfunc() {
        System.out.println("default method in B");
    }

    static void sfunc() {}
}

class Son implements A, B {

    @Override
    public void func() {

    }

    @Override
    public String func(int i) {
        return null;
    }

//    @Override
//    public void dfunc() {
//        A.super.dfunc();
//    }

    void f() {
        A.sfunc();
//        sfunc();
//        this.sfunc();
//        A.super.sfunc();

    }
}

class F {
    public static void f() {}
}

class FF extends F {
    void fs() {
        F.f();
        f();
        this.f();
        super.f();
    }
}