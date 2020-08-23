package com.fs;

/**
 * interface 的省略类
 */
public abstract interface Interfacee {

    public static final int i = 0;

    public abstract void func();

    default void dfunc() {}

    public static void sfunc() {}
}

abstract class AbtClass {
    public abstract void func1();
    protected abstract void func2();
    abstract void func3();
//    private abstract void func4(); // 报错
}