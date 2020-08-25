package com.basicjava.generic.p3;

// 泛型通配符
public class Test3 {

    public static void main(String[] args) {

        Generic<Integer> g1 = new Generic<>("1", 1);
//        print(g1);   // 2.编译报错，虽然 Integer 是 Number 的子类，
                       //   但是 Generic<Integer> 并不能作为  Generic<Number> 的参数

        print2(g1);    // 4. 正常运行

    }

    // 1. 写一个方法，入参规定了泛型 Number
    private static void print(Generic<Number> generic) {
        System.out.println(generic.value);
    }

    // 3. 泛型通配符 ？
    private static void print2(Generic<? extends Number> generic) {
        System.out.println(generic.value);
    }
}

class Generic<T> {

    public String key;
    public T value;

    public Generic(String key, T value) {
        this.key = key;
        this.value = value;
    }
}