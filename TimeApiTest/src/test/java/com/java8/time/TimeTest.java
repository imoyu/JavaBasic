package com.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

public class TimeTest {

    @Test
    public void LocalDateTest() {

        LocalDate date = LocalDate.parse("2020-06-18");

        int year = date.getYear();
        Month month = date.getMonth();
        int monthValue = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfYear = date.getDayOfYear();

        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));

        System.out.println(date.withYear(1000));
        System.out.println(date.withMonth(12));
        System.out.println(date.withDayOfYear(134));
        System.out.println(date.withDayOfMonth(29));

        LocalDate date1 = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println(date1);

        System.out.println(date.isBefore(date.withDayOfMonth(1)));
        System.out.println(date.isSupported(ChronoUnit.DAYS));
        long until = date.until(LocalDate.parse("2020-06-17"), ChronoUnit.DAYS);
    }

    @Test
    public void DateTimeTest() {

        LocalTime time = LocalTime.parse("16:23:45");
        System.out.println(time);

        LocalDateTime dateTime = time.atDate(LocalDate.of(2001, 9, 15));

        String timeS = time.format(DateTimeFormatter.ISO_LOCAL_TIME);

        LocalTime time1 = time.with(LocalTime.MIDNIGHT);
        System.out.println(time1);

    }

    @Test
    public void LocalDateTimeTest() {

        LocalDateTime dateTime = LocalDateTime.parse("2020-07-19T15:34:55", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        System.out.println(dateTime);

        LocalTime local = LocalTime.parse("23:59:59");
        LocalDateTime passTemporal = LocalDateTime.now().plusDays(1L);
        System.out.println("passTemporal : " + passTemporal);
        Temporal returnTemporal = local.adjustInto(passTemporal);
        System.out.println("adjustInto   : " + returnTemporal);

        LocalDateTime localDateTime = passTemporal.truncatedTo(ChronoUnit.HOURS);
        System.out.println(localDateTime);
    }

    @Test
    public void ClockTest() {

        Clock clock = Clock.systemUTC();
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        System.out.println(clock.millis());

    }

    @Test
    public void DurationTest() {

        Duration between = Duration.between(LocalDate.of(2001, 6, 13).atTime(15, 30), LocalDateTime.parse("2001-06-23T15:37:55"));
        System.out.println(between.getSeconds());

    }

    @Test
    public void InstantTest() {

        System.out.println(Instant.now().plus(8, ChronoUnit.HOURS));
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.UTC));

        Instant now = Instant.now();

    }

    @Test
    public void ZoneIdTest() {

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

    }
}
