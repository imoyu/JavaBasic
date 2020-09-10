package com.stream.turing.lambda;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//  https://www.jianshu.com/p/bec12aa21fc6
public class StreamEx {

    public static void main(String[] args) {
        System.out.println(
                map(Stream.of(
                        new Artist("a", "aaa"),
                        new Artist("b", "bbb"),
                        new Artist("c", "ccc")
                ), t -> t.getNation()).collect(Collectors.toList())
        );
    }

    private static  <T, R> Stream<R> map(Stream<T> stream, Function<T, R> fun) {

        return stream.reduce(Stream.empty(),  // Stream<R>是reduce参数的的U
                (u, t) -> Stream.concat(u, Stream.of(fun.apply(t))),
                (a, b) -> Stream.concat(a, b));
    }

}

class Artist {

    private String name;
    private String nation;

    public Artist(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}