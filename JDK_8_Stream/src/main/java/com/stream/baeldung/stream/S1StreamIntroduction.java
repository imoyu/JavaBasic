package com.stream.baeldung.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class S1StreamIntroduction {

    public static void main(String[] args) {

        Stream<String> das = Stream.of("das", "fdsd");

        List<String> list = new ArrayList<>();
//        Stream<String> stream = list.stream();

        List<Detail> details = new ArrayList<>();
        Stream<Detail> stream = details.stream();
        stream.flatMap(new Function<Detail, Stream<String>>() {
            @Override
            public Stream<String> apply(Detail detail) {
                return detail.getParts().stream();
            }
        });
        Function<Detail, Stream<?>> function = new Function<Detail, Stream<?>>() {
            @Override
            public Stream<?> apply(Detail detail) {
                return detail.getParts().stream();
            }
        };
    }

}

class Detail {
    private List<String> parts = new ArrayList<>();

    public List<String> getParts() {
        return parts;
    }
}