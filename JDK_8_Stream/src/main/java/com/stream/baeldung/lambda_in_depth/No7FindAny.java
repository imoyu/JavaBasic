package com.stream.baeldung.lambda_in_depth;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class No7FindAny {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            func();
        }

    }

    static void func() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list
                .stream().parallel()
                .filter(num -> num < 4).findAny();

//        System.out.println(result);

        System.out.println(list.stream().findAny());
    }
}
