package com.ituring.ex.cap5;

import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class No5_6_2_b {

    public static void main(String[] args) {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

//        HashMap<String, Integer> reduce = names.reduce(new HashMap<>(), (map, s) -> {
//            map.merge(s, 1, Integer::sum);
//            return map;
//        }, (map1, map2) -> {
//            map1.putAll(map2);
//            return map1;
//        });
//
//        System.out.println(reduce);
//
//        names.collect(Collectors.groupingBy(name -> name, Collectors.counting()));

//        names.collect(Collectors.toMap(name -> name, name -> 1, (oldValue, newValue) -> oldValue + 1));

        names.collect(Collector.of(HashMap<String, Integer>::new, (map, name) -> {
            map.merge(name, 1, Integer::sum);
        }, (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        }));
    }

}
