package com.ituring.demo.cap4;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class No5_3_7 {

    public static void main(String[] args) {
        String s = Stream.of("Micheal", "Mingx", "Xusk", "Tofee")
                .collect(new StringCollector(",", "[", "]"));

        System.out.println(s);

        StringJoiner joiner = new StringJoiner(",", "<", ">");
        List<String> list = Arrays.asList("Micheal", "Mingx", "Xusk", "Tofee");
        for (String s1 : list) {
            joiner.add(s1);
        }
        System.out.println(joiner.toString());

        StringJoiner reduce = list.stream()
                .reduce(new StringJoiner(",", "{", "}"),
                        (stringJoiner, s1) -> stringJoiner.add(s1),
                        (j1, j2) -> j1.merge(j2));

                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        String result = list.stream()
                .collect(Collector.of(() -> new StringJoiner(","),
                        StringJoiner::add,
                        StringJoiner::merge))
                .toString();

    }

}

class StringCollector implements Collector<String, StringJoiner, String> {

    String separator;
    String prefix;
    String suffix;

    public StringCollector(String separator) {
        this.separator = separator;
    }

    public StringCollector(String separator, String prefix, String suffix) {
        this.separator = separator;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringJoiner> supplier() {
        return () -> new StringJoiner(separator, prefix, suffix);
    }

    @Override
    public BiConsumer<StringJoiner, String> accumulator() {
        return StringJoiner::add;
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {
        return StringJoiner::merge;
    }

    @Override
    public Function<StringJoiner, String> finisher() {
        return StringJoiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> set = new HashSet<>();
        set.add(Characteristics.UNORDERED);
//        set.add(Characteristics.IDENTITY_FINISH); // 设置了这个后 finisher 就不转换了
        return set;
    }

}
