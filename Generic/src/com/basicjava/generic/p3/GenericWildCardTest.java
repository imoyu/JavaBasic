package com.basicjava.generic.p3;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符用于泛型的使用
 * 见 Typora 笔记：Java 知识点专题
 */
public class GenericWildCardTest {

    public static void main(String[] args) {

        List<?> list1 = new ArrayList<>();
//        list1.add(new Integer(1));

        List<? extends B> list2 = new ArrayList<>();
//        list2.add(new C());

        List<? super B> list3 = new ArrayList<>();
        list3.add(new C());
        list3.add(new B());
//        list3.add(new A());
    }

}

class A { }

class B extends A { }

class C extends B { }
