package com.fs.anonymous;

public class T1 {

    static abstract class Person {
        public abstract void eat();
    }

    static class Child extends Person {
        int a = 1;
        int b = 2;
        public void childeat() {
            System.out.println("childeat ------");
        }
        @Override
        public void eat() {
            System.out.println("child eat");
        }
    }

    static class CC extends Child {
        int a = 3;
        @Override
        public void eat() {
            System.out.println("cc eat");
        }
    }

    public static void main(String[] args) {
        Child child = new CC();
        child.eat();  // cc eat
        child.childeat();  // childeat ------
        System.out.println(child.a); // 1
        System.out.println(child.b); // 2

        Person p = new Child();

        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Child); // true
        System.out.println(p instanceof CC); // false

        long l;
        char c = 'd';
        l = c;

        double d1 = -1.0;
        System.out.println(d1 < Double.MIN_VALUE);
    }
}
