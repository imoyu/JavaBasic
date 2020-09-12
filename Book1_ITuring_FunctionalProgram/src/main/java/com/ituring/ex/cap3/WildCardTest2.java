package com.ituring.ex.cap3;

import java.util.ArrayList;
import java.util.List;

public class WildCardTest2 {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

//        sort1(dogs); // Error dogs 未实现 Comparable<Dog> ，所以报错
        sort2(dogs);

        // T 直接做参数，情况各异 ===================================================

        f1(new Dog()); // 这个未实现 Comparable<Dog> 为什么可以
        f2(new Dog()); // 实现了 Comparable<Dog 或 Dog 父类>
        f3(new Dog()); // 这个未实现 Comparable<Dog or Dog子类> 为什么可以
        // 推测是由于向上转型，T 可以看成是 Animal

//        f1(new Dog2());// Error
//        f2(new Dog2());// Error
        f3(new Dog2());
        // ? extends T 是 Animal,T 是 Object，可以传入任意类型
        // 相当于：
        f3((Comparable<Animal>) o -> 0);

//        f1(new Dog3());// Error
        f2(new Dog3());// T 是 Dog3，Comparable 的 泛型是 Object，满足 ? super T
//        f3(new Dog3());// Error

        // =========================================================================

        new Zoo<Animal>();
//        new Zoo<Dog>(); // Error
    }

    static <T extends Comparable<T>> void sort1(List<T> list) {}
    static <T extends Comparable<? super T>> void sort2(List<T> list) {}

    // T 必须实现 Comparable<U> 接口，并且 U 是 T
    static <T extends Comparable<T>> void f1(T t) {}

    // T 必须实现 Comparable<U> 接口，并且 U 是 T 或其父类
    // 一般实现是 父类实现了 T extends Comparable<T>，子类继承父类
    static <T extends Comparable<? super T>> void f2(T t) {}

    // T 必须实现 Comparable<U> 接口，并且 U 是 T 或其子类
    // 不符合逻辑，基本不用
    static <T extends Comparable<? extends T>> void f3(T t) {}

}

class Animal implements Comparable<Animal>{

    int num;

    @Override
    public int compareTo(Animal o) {
        return num - o.num;
    }
}

class Dog extends Animal {}

class Dog2 implements Comparable<Animal> {
    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}

class Dog3 implements Comparable<Object> {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Zoo<T extends Comparable<T>> {}