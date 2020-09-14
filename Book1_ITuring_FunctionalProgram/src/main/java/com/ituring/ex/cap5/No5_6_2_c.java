package com.ituring.ex.cap5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class No5_6_2_c {

    public static void main(String[] args) {
        Map<String, List<String>> collect = Stream.of("Koko", "looo", "ppp", "looo", "ppp", "looo")
                .collect(new GroupingBy<>(s -> s));
        System.out.println(collect);
    }

}

class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private final Function<? super T, ? extends K> classifier;

    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    // 初始化一个容器
    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    // 如何累加
    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, e) -> {
            K key = classifier.apply(e);
            List<T> es = map.computeIfAbsent(key, k -> new ArrayList<>());
            es.add(e);
        };
    }

    // 如何合并
    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (left, right) -> {
            right.forEach((key, value) -> {
                left.merge(key, value, (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                });
            });
            return left;
        };
    }

    // 如何转换
    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return map -> map;
    }

    // 表明特征
    @Override
    public Set<Characteristics> characteristics() {
        HashSet<Characteristics> set = new HashSet<>();
        set.add(Characteristics.IDENTITY_FINISH);
        return set;
    }
}