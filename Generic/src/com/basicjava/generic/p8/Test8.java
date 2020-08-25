package com.basicjava.generic.p8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test8 {

    public static void main(String[] args) {
        System.out.println(ResponseCodeImpl.SUCCESS.code());
        System.out.println(ResponseCodeImpl.SUCCESS.msg());
        System.out.println(ResponseCodeImpl.SUCCESS.name());

        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList = fromArrayToList(intArray, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        });
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }
}
