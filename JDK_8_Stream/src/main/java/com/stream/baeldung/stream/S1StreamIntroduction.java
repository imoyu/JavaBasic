package com.stream.baeldung.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class S1StreamIntroduction {

    public static void main(String[] args) {

        Stream<String> das = Stream.of("das", "fdsd");

        List<String> list = new ArrayList<>();
//        Stream<String> stream = list.stream();

        List<Detail> details = new ArrayList<>();
        Stream<Detail> stream = details.stream();
        stream.flatMap(new Function<Detail, Stream<String>>() {
            @Override
            public Stream<String> apply(Detail detail) {
                return detail.getParts().stream();
            }
        });
        Function<Detail, Stream<?>> function = new Function<Detail, Stream<?>>() {
            @Override
            public Stream<?> apply(Detail detail) {
                return detail.getParts().stream();
            }
        };
        Stream.of("").allMatch(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("look");
            }
        });
        // 一个类没有重写 equals，就会调用父类的 equals
        // 如果父类重写了 equals 和 hashcode，子类没有，调用 equals 相当于比较父类
        PP pp1 = new PP();
        pp1.j = 10;
        PP pp2 = new PP();
        pp2.j = 11;
        System.out.println(pp1.equals(pp2));

//        Stream.of("", "f").collect();
//        Stream.of(1, 2).collect();
//        Stream.of(new Object()).collect();

    }

}

class Detail {
    private List<String> parts = new ArrayList<>();

    public List<String> getParts() {
        return parts;
    }
}

class P {
    int i;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        P p = (P) o;

        return i == p.i;
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class PP extends P {
    int j;
}