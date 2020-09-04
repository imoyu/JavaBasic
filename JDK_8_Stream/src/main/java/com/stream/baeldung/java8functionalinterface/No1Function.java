package com.stream.baeldung.java8functionalinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class No1Function {

    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);
        System.out.println(value);
        System.out.println(nameMap.get("John"));

        Function<Object, String> f1 = v -> {
            System.out.println("f1");
            return v.toString();
        };

        Function<String, String> f2 = s -> {
            System.out.println("f2");
            return "`".concat(s).concat("`");
        };

        // 先执行 f1，再执行 f2
        Function<Integer, String> f1f2 = f2.compose(f1);

        System.out.println(f1f2.apply(2));

        BiFunction biFunction = (a, b) -> null;
        BiConsumer biConsumer = (a, b) -> {};
        Supplier<String> supplier = () -> "";

        Function<Object, String> function = (o) -> o.toString();

        int v1 = 0;
        int v2 = 0;
        v2 = 9;
        new ArrayList<>().forEach(o -> {
            System.out.println(v1);
//            System.out.println(v2);  // Error
        });

    }

}
