package com.fs.anonymous;

public class T2 {

    static abstract class Person {
        public abstract void eat();
    }

    public static void main(String[] args) {

        Person person = new Person() {
            @Override
            public void eat() {
                System.out.println("anonymous eat --");
            }
        };

        // 相当于
        class Child extends Person {

            @Override
            public void eat() {
                System.out.println("anonymous eat --");
            }
        }
        Person p2 = new Child();

        person.eat();
        p2.eat();
    }
}
