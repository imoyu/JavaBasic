package com.basicjava.generic.p4;

// 泛型方法
public class Test4 {

    public static void main(String[] args) {

    }

    // 1. 方法泛型是指作用在方法上的 T，后面 返回值，入参，入参的泛型等地方都能使用这个 T
    public <T> T genericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        return t;
    }

}

class Generate<T> {

    private <E> void func1(E t) {

    }

    // 2. 这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型
    private <T> void func2(T t) {

    }

}
