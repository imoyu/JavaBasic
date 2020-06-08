package com.basicjava.generic.p1;

// https://blog.csdn.net/s10461/article/details/53941091

// 1. 普通的泛型类
public class Test1 {

    public static void main(String[] args) {

        Generic<Integer> generic = new Generic("name",123);
        Integer value = generic.value;

        System.out.println(value.getClass());
    }

}

// 普通的泛型，集合类就是这么定义的
class Generic<T> {

    public String key;

    public T value;

    public Generic(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
