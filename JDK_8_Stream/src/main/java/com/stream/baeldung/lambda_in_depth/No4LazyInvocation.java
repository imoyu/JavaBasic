package com.stream.baeldung.lambda_in_depth;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class No4LazyInvocation {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc1", "abc2", "abc32");
        Optional<String> first = list.stream()
                .filter(s -> {
                    System.out.println("filter() is called & element = " + s);
                    return s.contains("2");
                })
                .map(s -> {
                    System.out.println("map() is called & element = " + s);
                    return s.toUpperCase();
                })
                .reduce((s1, s2) -> s1 + s2);

        System.out.println(first.orElse(null));
    }

}
