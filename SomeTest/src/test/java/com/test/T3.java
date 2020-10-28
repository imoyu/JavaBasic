package com.test;

import org.junit.Test;

import java.util.*;

public class T3 {

    @Test
    public void doubleTest() {

        double d1 = 1.25;
        double d2 = 1.5;
        double d3 = 1.1;
        double d4 = 1.2;

        System.out.println(d1 + d2);
        System.out.println(d3 + d4);
        System.out.println(d1 + d4);
        System.out.println(0.01 + 0.05);
        byte b = -5;
        System.out.println(b >>> (byte) 2);
        byte y = -2;
        // byte short char 参与运算结果会自动升级为 int，不管有没有 int 参与
        int i2 = b + y;
        short s1 = 9;
        short s2 = 9;
        int i1 = s1 + s2;
        char c1 = 2;
        char c2 = 2;
        int i = c1 + c2;
    }

    @Test
    public void BitOpTest() {

        // a % 2^n  ==>  a & 2^n - 1
        System.out.println(15 % 8);
        System.out.println(15 & 7);

    }

    @Test
    public void SystemSeparatorTest() {

        System.out.println("-------------");
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.lineSeparator());
        System.out.println("-------------");

        int a = 3;


    }

    @Test
    public void ReduceTest() {

        List<String> list = Arrays.asList("colection");

        Optional<String> reduce = list.stream()
                .reduce((s1, s2) -> s1 + " " + s2);

        System.out.println(reduce.get());

    }

    @Test
    public void OptionalTest() {

        Optional<Dog> ii = Optional.of(new Dog("ii"));
        System.out.println(ii.map(Dog::getName));

        Optional<Dog> ii2 = Optional.empty();
        System.out.println(ii2.map(Dog::getName));

    }

    @Test
    public void MethodReferenceTest() {

        List<String> origin = new ArrayList<>();
        List<String> res = new ArrayList<>();

        origin.stream()
                .filter(Objects::nonNull)
                .forEach(res::add);

    }

    @Test
    public void streamMapTest() {

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("小黄"));
        dogs.add(new Dog("小白"));
        dogs.add(null);
        dogs.add(new Dog("小灰"));

        dogs.stream()
                .filter(Objects::nonNull)
                .map(Dog::getName)
                .peek(System.out::println)
                .peek(System.out::println)
                .peek(System.out::println)
                .forEach(System.out::println);
    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}