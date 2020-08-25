package com.basicjava.generic.p6;

// 泛型的上下边界
public class Test6 {

    public static void main(String[] args) {

    }

    // 1. 定义上边界
    public static void func1(Generic<? extends Father> generic) {}
    public static void func2(Generic<? super Son> generic) {}
}

class Father {}

class Son extends Father {}

// 1. 定义上边界
class Generic<T extends Object> {

    public <E extends Number & Comparable<Number>> void f(E[] a) {

    }

}