package com.basicjava.generic.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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

        f(new G<>(), new G<>());
        f(new G<B>(), new G<B>());
//        f(new G<A>(), new G<A>());
//        f(new G<C>(), new G<C>());
        f(new G<C>(), new G<A>());

        f2(new AG<H<H>>() {
            @Override
            public H<H> func() {
                return null;
            }
        });

        f4(new AG<A>() {
            @Override
            public B func() {
                return new C();
            }
        });

        f3(new Function<Integer, B>() {

            @Override
            public C apply(Integer integer) {
                return null;
            }
        });
        f3(new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return "null";
            }
        });
        f3(new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return "";
            }
        });

        f5(new G());
        f5(new G<>());
        f5(new G<String>());

        f6(new G<A>());

        A a = f7(new G<>(new B()));
        B b = f7(new G<>(new B()));
//        C c = f7(new G<>(new B()));

        G<A> ga1 = f11(new G<>(new B()));
        G<B> gb1 = f11(new G<>(new B()));
//        G<C> gc1 = f11(new G<>(new B()));

        A a2 = f8(new G<>(new B()));
        B b2 = f8(new G<>(new B()));
        C c2 = f8(new G<>(new B()));

        A g = f10(new AB<B>() {
            @Override
            public void func(B b) {

            }
        });
        C c = f10(new AAB());
//        G<A> gc = f15(new G<B>());  // G<B> 不能向上转为 G<A>

        G<A> ga2 = f12(new G<>(new B()));
        f9(new G<>(new B()));
        G<B> gb2 = f12(new G<>(new B()));
        G<C> gc2 = f12(new G<>(new B()));

        f13(new G<A>());
        f13(new G<B>());
//        f13(new G<C>());

        List<? super B> l = new ArrayList<>();
        l.add(new C());

//        fun(new ArrayList<C>());
        G<B> bg = fun1(new G<>());
        G<B> bg1 = fun2(new G<>(new B()));
    }

    static <T> G<T> fun1(G<? super T> g) {
        return null;
    }
    static <T> G<T> fun2(G<? extends T> g) {
        return null;
    }

    static void fun(List<? super B> l) { }

    private static class AAB extends AB<B> {
        @Override
        public void func(B b) {

        }
    }

    static void f(G<? extends B> g1, G<? super B> g2) {
//        System.out.println(g1.t.getClass());
//        System.out.println(g2.t.getClass());
    }

    static <K extends H<? super K>> void f2(AG<? extends K> h1) {

    }
    static <K> void f4(AG<? extends K> h1) {

    }

    static void f5(G<?> g) {}
    static <T> void f6(G<T> g) {}
    static <T> T f7(G<? extends T> g) {
        T t = g.t;
        System.out.println(g.t.getClass());
        return (T) g.t;

    }
    static <T> G<T> f11(G<? extends T> g) {
        return null;
    }
    static <T> G<T> f12(G<? super T> g) {
        return null;
    }
    static <T> void f9(G<? super T> g) {
    }

    static <T> T f8(G<? super T> g) {
        Object o = g.t;
        System.out.println(g.t.getClass());
        return (T) g.t; // Unchecked cast: 'capture<? super T>' to 'T'

    }
    static <T> T f10(AB<? super T> ab) {
        return null;
    }
    static <T> G<T> f15(G<? super T> g) {
        return null;
    }

    static <T, U extends Comparable<? super U>> void f3(Function<? super T, ? extends U> function) {

    }

    static B f8() {
        return new C();
    }

    static void f13(G<? super B> g) {}
    static void f14(AG<? super B> g) {}
}

class A { }
class B extends A implements Comparable<B>{
    @Override
    public int compareTo(B o) {
        return 0;
    }
}
class C extends B { }
class G<T> {
    T t;

    public G() {
    }

    public G(T t) {
        this.t = t;
    }
}
class H<T> extends G<T> {}
class J<T> extends H<T> {}

abstract class AG<T> {
    public abstract T func();
}

abstract class AB<T> {
    public abstract void func(T t);
}
