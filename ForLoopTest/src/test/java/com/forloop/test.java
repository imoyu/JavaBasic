package com.forloop;

import org.junit.Test;

import java.util.*;

public class test {


    List<Integer> arrayList = new ArrayList();
    List<Integer> linkedList = new LinkedList();
    List<Integer> list = new ArrayList<>();
    Map<String, String> map = new HashMap<>();

    int num = 0;
    {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int val = r.nextInt(1000) + 1;
            arrayList.add(val);
            linkedList.add(val);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    @Test
    public void Loop1Test() {

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
            linkedList.remove(i);
        }
        System.out.println();
    }

    @Test
    public void Loop2Test() {

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

    }

    @Test
    public void Loop3Test() {

        for (Integer num : linkedList) {
            linkedList.add(0);
            System.out.print(num + " ");
        }
        System.out.println();

    }

    @Test
    public void Loop4Test() {

        linkedList.forEach(num -> {
            System.out.print(num + " ");
        });
        System.out.println();

    }

    @Test
    public void IterLoopTest() {

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            iterator.remove();
//            System.out.print(next + " ");
//        }
//        System.out.println();
//        System.out.println(list);

        for (Integer num : list) {
            list.set(1, 2);
//            list.remove(3);
//            list.add(10);
        }
    }

    @Test
    public void MapTest1() {

        map.forEach((key, val) -> {
            System.out.println(key + " : " + val);
        });

    }
}
