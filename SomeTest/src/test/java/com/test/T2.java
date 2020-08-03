package com.test;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T2 {

    @Test
    public void stringFormatTest() {

        System.out.printf("%s %s %d%n", 21, 163232323232323L, 020);

    }

    @Test
    public void localDateTimeTest() {

        LocalDateTime estimatedTime = LocalDateTime.parse("2020-08-01 11:33:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.parse("2020-08-03 11:33:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Duration duration = Duration.between(now, estimatedTime); // 尾减头
        System.out.println(duration.toHours()); // -48

        String s = now.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
        System.out.println(s);

    }

}
