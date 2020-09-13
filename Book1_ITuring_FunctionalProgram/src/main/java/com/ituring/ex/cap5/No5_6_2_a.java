package com.ituring.ex.cap5;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No5_6_2_a {

    public static void main(String[] args) {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

        names.collect(Collectors.maxBy(Comparator.comparing(String::length))).orElse(null);


        String s = names.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2).orElse(null);
    }

}
