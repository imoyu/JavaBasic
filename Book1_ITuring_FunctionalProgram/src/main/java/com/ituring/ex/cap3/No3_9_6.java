package com.ituring.ex.cap3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class No3_9_6 {

    private static int countLowercaseLetters(String s) {
        long count = s.chars()
                .filter(Character::isLowerCase)
                .count();
        return (int) count;
    }

    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(No3_9_6::countLowercaseLetters));
    }

}
