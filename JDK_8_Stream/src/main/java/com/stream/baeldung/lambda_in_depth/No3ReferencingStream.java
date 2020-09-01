package com.stream.baeldung.lambda_in_depth;

import java.util.stream.Stream;

public class No3ReferencingStream {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c", "zz");
        stream.filter(s -> s.length() == 2);

        stream.filter("a"::equals);

        stream.forEach(System.out::println);

        // rebase 测试 init
        // ----------- 1
        // ----------- 2
        // ----------- 3
    }

}
