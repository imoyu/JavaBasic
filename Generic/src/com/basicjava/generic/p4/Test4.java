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
    // T 的确定：
    //           1) 普通泛型，由 new 一个类时，类后面的 <T> 确定
    //           2) 方法泛型，由方法参数里的 T 决定
    //           3) T 只能用于声明变量 `T t = ...;` √, 不能用于调用方法 T.class X
    public <T> T genericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        return t;
    }

    public static <E> Generic<E> func1() {

        if (new Random().nextBoolean())
            return (Generic<E>) new Generic<Integer>();
        else
            return (Generic<E>) new Generic<String>();

    }

    public static Generic func2() {

        if (new Random().nextBoolean())
            return (Generic) new Generic<Integer>();
        else
            return (Generic) new Generic<String>();

    }

    public static Generic<?> func3() {

        if (new Random().nextBoolean())
            return new Generic<Integer>();
        else
            return new Generic<String>();

    }

    public static Generic func4() {

        if (new Random().nextBoolean())
            return new Generic<Integer>();
        else
            return new Generic<String>();

    }

    public static Generic<?> func5() {

        if (new Random().nextBoolean())
            return Generic.success(new Integer(12));
        else
            return Generic.success("ds");

    }

    public static <T> Generic<T> func6(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        return new Generic<>(t);
    }
}

class Generic<T> {

    private T tt;

    protected Generic() {

    }

    protected Generic(T tt) {
        this.tt = tt;
    }

    public static <E> Generic<E> success(E e) {
        return new Generic<>(e);
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
