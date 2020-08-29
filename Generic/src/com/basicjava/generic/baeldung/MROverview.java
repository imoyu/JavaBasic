package com.basicjava.generic.baeldung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MROverview {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("tom", "jack", "lily", "sally");

        // 1.1 静态方法（其他类）
        strings.forEach(A::opWithString);
        System.out.println(strings);

        // 1.2 静态方法（当前类）
        strings.forEach(MROverview::opWithString);

        // 2 特定对象的实例方法
        strings.forEach(new A()::opWithStringCM);

        // 3 特定类型的任意对象的实例方法（调用实例方法）
        List<MROverview> mrOverviews = new ArrayList<>();
        // 条件：参数列表的第一个参数，是 Lambda 表达式的调用者，剩下的参数和调用的函数参数一致

        mrOverviews.forEach(MROverview::noArgMethod);
        mrOverviews.forEach(new Consumer<MROverview>() {
            @Override
            public void accept(MROverview mrOverview) {

            }
        });
        Consumer<MROverview> consumer = mrOverview -> {};

        mrOverviews.sort(MROverview::compareMethod);
        mrOverviews.sort((o1, o2) -> o1.compareMethod(o2));
        mrOverviews.sort(new Comparator<MROverview>() {
            @Override
            public int compare(MROverview o1, MROverview o2) {
                return 0;
            }
        });
        Comparator<MROverview> comparator = new Comparator<MROverview>() {
            @Override
            public int compare(MROverview o1, MROverview o2) {
                return o1.compareMethod(o2);
            }
        };
        mrOverviews.sort(comparator);

        BiConsumer<A, MROverview> instanceMethod = A::instanceMethod;
        instanceMethod.accept(new A(), new MROverview());

        Consumer<A> func = A::func;

        BiConsumer<A, MROverview> biConsumer = new BiConsumer<A, MROverview>() {
            @Override
            public void accept(A a, MROverview mrOverview) {

            }
        };
        FI<A, String, Integer> treeArgsClass = A::run;

        List<Integer> nums = Arrays.asList(6, 2, 5, 3, 4, 7, 9, 1);
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        calFun1(() -> {});
        calFun2(() -> null);
        calFun2(B::func2);

        calFun4(B::func4);
        calFun4(B::func5);

        FunArg1 funArg1 = s -> {};
        FunArg2 funArg2 = (s, b) -> System.out.println();

        FunGeneric funGeneric = new FunGeneric<String>() {
            @Override
            public String f() {
                return "";
            }
        };

        calFun5(new FunGeneric<String>() {
            @Override
            public String f() {
                return "null";
            }
        });
    }

    static String opWithString(String str) {
        return str.toUpperCase();
    }

    void op(OP op, MROverview mrOverview, String str) {
        op.func(mrOverview, str);
    }

    void noArgMethod() {}

    int compareMethod(MROverview mrOverview) {
        return -1;
    }

    static void calFun1(FunVoid funVoid) {
        funVoid.f();
    }
    static String calFun2(FunString funString) {
        return funString.f();
    }
    static Integer calFun3(FunInteger funInteger) {
        return funInteger.f();
    }
    static FF calFun4(FunFF funFF) {
        return funFF.f();
    }
    static <T> T calFun5(FunGeneric<? extends T> funGeneric) {
        return funGeneric.f();
    }
}

class F {}
class FF extends F {}
class FFF extends FF {}

class B {
    static void func1() {};
    static String func2() {
        return null;
    };
    static Integer func3() {
        return null;
    };
    static FF func4() {
        return null;
    }
    static FFF func5() {
        return null;
    }
}

class A {

    static void opWithString(String str) {
        System.out.println(str);
    }

    void opWithStringCM(String str) {

    }

    void instanceMethod(MROverview mr1) {

    }

    void run(String s, Integer i) {}

    void methodForCal(A a, String s, Integer i) {
        // some operation
    }

    void func() {}
    
    void getZeroOrOne(Integer i) {
//        return new Random().nextInt(2);
    }
}

abstract class OP {
    protected abstract void func(MROverview mrOverview, String str);
}

abstract class TreeArgsClass<K, T, V> {
    abstract void cal(K k, T t, V v);
}

@FunctionalInterface
interface FunVoid {
    void f();
}

@FunctionalInterface
interface FunArg1 {
    void f(String s);
}

@FunctionalInterface
interface FunArg2 {
    void f(String s, B b);
}

@FunctionalInterface
interface FunString {
    String f();
}

@FunctionalInterface
interface FunInteger {
    Integer f();
}

@FunctionalInterface
interface FunFF {
    FF f();
}

@FunctionalInterface
interface FunGeneric<T> {
    T f();
}