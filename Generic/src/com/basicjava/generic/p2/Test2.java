package com.basicjava.generic.p2;


// 泛型接口
public class Test2 {



}

// 实现的接口可以不带泛型
class SonGenerator implements Generator {

    @Override
    public Object next() {
        return null;
    }
}

// 带泛型的话，实现类也要带泛型，声明 Generator 的 T 是哪来的
class Son2Generator<T> implements Generator<T> {
    @Override
    public T next() {
        return null;
    }
}