package com.fs.package2;

import com.fs.package1.ClassA;

public class ClassB extends ClassA{

    public static void main(String[] args) {
        ClassA a = new ClassA();
//        System.out.println(a.a);
//        System.out.println(a.b);
        // 不在同一个包，报错

        ClassB b = new ClassB();
//        System.out.println(b.a);    // a 是 default，子类不能引用
        System.out.println(b.b);      // b 是 protect，子类可以调用
    }

}
