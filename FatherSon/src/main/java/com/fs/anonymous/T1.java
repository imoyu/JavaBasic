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
        int c = 4;
        @Override
        public void eat() {
            System.out.println("cc eat");
        }
        public void cc() {}
    }

    static class CC2 extends Child {

    }

    public static void main(String[] args) {
        Child child = new CC();
        child.eat();  // cc eat
        child.childeat();  // childeat ------
//        child.cc();  // 报错
        System.out.println(child.a); // 1
        System.out.println(child.b); // 2
//        System.out.println(child.c); // 报错

        CC cc = (CC) child;
        cc.eat(); // cc eat
        cc.childeat(); // childeat ------
        System.out.println(cc.a); // 3
        System.out.println(cc.b); // 2

        Person p = new Child();
        CC cc2 = new CC();

        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Child); // true
        System.out.println(p instanceof CC); // false
//        System.out.println(cc2 instanceof CC2); // 报错

        long l;
        char c = 'd';
        l = c;
        double d1 = -1.0;
        System.out.println(d1 < Double.MIN_VALUE);
    }
}
