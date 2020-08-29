package com.basicjava.generic.baeldung;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
        messages.stream().map(StringUtils::capitalize).forEach(System.out::println);
        messages.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .sorted(Integer::compareTo)
                .close();
    }

}
