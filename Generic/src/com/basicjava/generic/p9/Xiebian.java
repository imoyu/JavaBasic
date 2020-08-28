package com.basicjava.generic.p9;

import java.util.ArrayList;
import java.util.List;

public class Xiebian {

    public static void main(String[] args) {

        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[0] = new Fruit(); // 编译通过，运行出错
        Fruit fruit = fruits[0];

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList();
        List list4 = new ArrayList<Integer>();
        List list5 = new ArrayList<>();

        list3.add(321);
        Integer integer = list3.get(0);

        list4.add("123ddsa");
        Object o = list4.get(0);
        System.out.println(o);

//        G<String>[] gs = new G<String>[10]; // Error
    }

}
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
class G<T> {}