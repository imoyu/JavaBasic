package com.stream.baeldung.lambda_in_depth;

import java.util.stream.Stream;

public class No5ReduceMethod {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4)
                .filter(e -> {
                    System.out.println("filter: " + e + "---------------");
                    return true;
                })
                .reduce((e1, e2) -> {
                    System.out.println("e1: " + e1);
                    System.out.println("e2: " + e2);
                    System.out.println("e1 + e2: " + (e1 + e2));
                    return e1 + e2;
                });
    }

}
