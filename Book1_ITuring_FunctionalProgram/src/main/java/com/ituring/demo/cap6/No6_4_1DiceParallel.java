package com.ituring.demo.cap6;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class No6_4_1DiceParallel {

    public static void main(String[] args) {

        int N = 200_000_000;
        parallelStart(N);
        System.out.println("----------------------------------------------");
        start(N);
    }

    private static void parallelStart(int N) {
        Instant start = Instant.now();

        Map<Integer, Double> map = parallelDiceRolls(N);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis() + " ms");

        System.out.println(map);
    }

    private static void start(int N) {
        Instant start = Instant.now();

        Map<Integer, Double> map = diceRolls(N);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis() + " ms");

        System.out.println(map);
    }

    private static Map<Integer, Double> parallelDiceRolls(int N) {

        double fraction = 1.0 / N;

        return IntStream.range(0, N)
                .parallel()
                .map(i -> twoDiceThrows())
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.summingDouble(n -> fraction)));

    }
    private static Map<Integer, Double> diceRolls(int N) {

        double fraction = 1.0 / N;

        return IntStream.range(0, N)
                .map(i -> twoDiceThrows())
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.summingDouble(n -> fraction)));

    }

    private static int twoDiceThrows() {
        Random random = new Random();
        int first = random.nextInt(6) + 1;
        int second = random.nextInt(6) + 1;
        return first + second;
    }
}
