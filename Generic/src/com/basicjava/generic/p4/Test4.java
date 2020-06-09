package com.basicjava.generic.p4;

import java.lang.reflect.ParameterizedType;
import java.util.Random;

// 泛型方法
public class Test4 {

    public static void main(String[] args) {

        System.out.println(func3().t.getClass());
        System.out.println(func4().t.getClass());
        System.out.println(func5().t.getClass());

        Integer i = (Integer) new Object();
        System.out.println(i.getClass());
    }

    // 1. 方法泛型是指作用在方法上的 T，后面 返回值，入参，入参的泛型等地方都能使用这个 T
    public <T> T genericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        return t;
    }

    public static <E> Generate<E> func1() {

        if (new Random().nextBoolean())
            return (Generate<E>) new Generate<Integer>();
        else
            return (Generate<E>) new Generate<String>();

    }

    public static Generate func2() {

        if (new Random().nextBoolean())
            return (Generate) new Generate<Integer>();
        else
            return (Generate) new Generate<String>();

    }

    public static Generate<?> func3() {

        if (new Random().nextBoolean())
            return new Generate<Integer>();
        else
            return new Generate<String>();

    }

    public static Generate func4() {

        if (new Random().nextBoolean())
            return new Generate<Integer>();
        else
            return new Generate<String>();

    }

    public static Generate<?> func5() {

        if (new Random().nextBoolean())
            return Generate.success(new Integer(12));
        else
            return Generate.success("ds");

    }

    public static <T> Generate<T> func6(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        return new Generate<>(t);
    }
}

class Generate<T> {

    private T tt;

    protected Generate() {

    }

    protected Generate(T tt) {
        this.tt = tt;
    }

    public static <E> Generate<E> success(E e) {
        return new Generate<>(e);
    }

    T t = (T) new Object();

    public Class<T> getTClass() {  // https://blog.csdn.net/hellozhxy/article/details/82024712
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    private <E> void func1(E t) {

    }

    // 2. 这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型
    private <T> void func2(T t) {

    }

}
