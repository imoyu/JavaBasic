package com.stream.baeldung.lambda_in_depth;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No6Collectors {

    public static void main(String[] args) {
        Stream<String> stream = Stream.<String>builder().add("Tom").add("Micheal").add("Top").add("Zook").build();
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        // 待理解：功能 reduce to a LinkedList<T>
        Collector.of(LinkedList::new, LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });

        // close()
        Stream.of("fa", "jk", "cc")
                .filter(s -> {
                    System.out.println("filter");
                    return true;
                })
                .peek(System.out::println)
                .close();
    }

}
