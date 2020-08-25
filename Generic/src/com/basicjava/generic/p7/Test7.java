package com.basicjava.generic.p7;

import java.util.LinkedList;
import java.util.List;

// 泛型数组 （泛型擦除）

public class Test7 {

    public static void main(String[] args) {

        // 1. 在java中是 "不能创建一个确切的泛型类型的数组"
//        List<String>[] ls = new LinkedList<String>[10];   // 编译报错

        // 这个和上面有什么区别？  见 // 泛型擦除： https://www.cnblogs.com/wuqinglong/p/9456193.html
        List<String>[] ls = new LinkedList[10];
//        ls[0].add(2);    // 编译报错
        ls[0].add("2");

    }

}
