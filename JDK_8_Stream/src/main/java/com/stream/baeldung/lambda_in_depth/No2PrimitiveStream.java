package com.stream.baeldung.lambda_in_depth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class No2PrimitiveStream {

    public static void main(String[] args) throws IOException {
        IntStream range1 = IntStream.range(1, 3);
        IntStream range2 = IntStream.rangeClosed(1, 3);
        range1.forEach(System.out::println);
        System.out.println();
        range2.forEach(System.out::println);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        Stream<Cup> cupStream = Stream.of(new Cup(), new Cup());
        Stream<Integer> integerStream = cupStream.map(Cup::getNum);
//        IntStream intStream = cupStream.mapToInt(Cup::getNum);

        "abc".chars().forEach(System.out::println);
        Path path = Paths.get("C:\\Users\\admin\\Desktop\\forRead.txt");
        Stream<String> lines = Files.lines(path);
        lines.forEach(System.out::println);

//        String s = null;
//
//        switch (s) { // 空指针
//            case "d": {
//                System.out.println("1");
//            }
//            case "a": {
//                System.out.println("2");
//            }
//            case "c": {
//                System.out.println("3");
//            }
//        }

        Map<String, String> map = new HashMap<>();
        map.put("null", "pol");
        System.out.println(map.get(null));
    }

}

class Cup {
    private int num;

    public int getNum() {
        return num;
    }
}