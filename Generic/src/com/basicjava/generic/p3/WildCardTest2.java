package com.basicjava.generic.p3;

import java.util.ArrayList;
import java.util.List;

public class WildCardTest2 {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

//        sort1(dogs); // Error
        sort2(dogs);
    }

    static <T extends Comparable<T>> void sort1(List<T> list) {
    }
    static <T extends Comparable<? super T>> void sort2(List<T> list) {
    }

}

class Animal implements Comparable<Animal>{
    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}

class Dog extends Animal {}
