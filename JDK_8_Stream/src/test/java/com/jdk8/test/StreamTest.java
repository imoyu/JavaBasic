package com.jdk8.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void Test() {

        List<String> list = new ArrayList<>();
        String s = list.stream().reduce((s1, s2) -> s1 + ";" + s2).orElse("null");
        System.out.println(s);
        String s1 = list.stream().collect(Collectors.joining(";"));
        System.out.println(s1.equals("")); // true
        List<String> list2 = Arrays.asList("Djkl", "Hulo", "Chi");
        String s2 = list2.stream().map(String::toUpperCase).collect(Collectors.joining(",", "(", ")"));
        System.out.printf("%s%n%s", s2, list2.get(0));
    }

}
