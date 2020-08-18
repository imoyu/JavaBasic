package com.fs.package1;

public class ClassB {

    int field1;

    {
        field1 = 12;
        System.out.println("执行构造块");
    }

    public ClassB(int field1) {
        this.field1 = field1;
    }

    static {
        System.out.println("执行静态块");
    }

    public ClassB() {
    }

    public static void main(String[] args) {
        ClassA a = new ClassA();
        System.out.println(a.a);
        System.out.println(a.b);

        ClassB b1 = new ClassB();
        System.out.println(b1.field1); // 12
        ClassB b2 = new ClassB(10);
        System.out.println(b2.field1); // 10
    }

}
