package com.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Date;

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


        System.out.println(localDateTime.query(TemporalQueries.zone()));
        System.out.println(localDateTime.query(TemporalQueries.zoneId()));
        System.out.println(localDateTime.query(TemporalQueries.chronology()));
        System.out.println(localDateTime.query(TemporalQueries.localTime()));
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
        System.out.println(between);
        System.out.println(between.getSeconds());
        System.out.println(between.getNano());

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
    public void MonthDayTest() {

        MonthDay monthDay = MonthDay.of(2, 29);
        MonthDay.parse("--10-01");
        System.out.println(monthDay.isValidYear(2021));

        Temporal temporal = monthDay.adjustInto(LocalDateTime.now());

        System.out.println(monthDay.range(ChronoField.DAY_OF_MONTH));

        System.out.println(monthDay.query(TemporalQueries.chronology()));
        System.out.println(monthDay.query(TemporalQueries.zone()));
        System.out.println(monthDay.query(TemporalQueries.zoneId()));
    }

    @Test
    public void OffsetDateTimeTest() {

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(4));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = offsetDateTime.toLocalDateTime();
        System.out.println(localDateTime);

        System.out.println(offsetDateTime.getOffset().getRules());

        System.out.println(offsetDateTime1.withOffsetSameLocal(ZoneOffset.UTC).toZonedDateTime());

    }

    @Test
    public void OffsetTimeTest() {

        OffsetTime offsetTime = OffsetTime.now();


    }

    @Test
    public void PeriodTest() {

        Period between = Period.between(LocalDate.parse("2020-03-01"), LocalDate.parse("2021-06-13"));
        System.out.println(between);

        System.out.println(Period.ofMonths(99).normalized());
    }

    @Test
    public void YearTest() {

        Year year = Year.now();

    }

    @Test
    public void YearMonthTest() {

        YearMonth yearMonth = YearMonth.now();

//        yearMonth

    }

    @Test
    public void ZoneDateTimeTest() {

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        System.out.println(localDateTime.query(TemporalQueries.zoneId()));
        System.out.println(localDateTime.query(TemporalQueries.zone()));
        System.out.println(zonedDateTime.query(TemporalQueries.zoneId()));
        System.out.println(zonedDateTime.query(TemporalQueries.zone()));

        System.out.println(localDateTime);
        System.out.println(zonedDateTime);

    }

    @Test
    public void ZoneIdTest() {

//        ZoneId.SHORT_IDS.forEach((k, v) -> {
//            System.out.println(k + " : " + v);
//        });
//
//        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        System.out.println(zoneId.getId());
        System.out.println(zoneId.getRules());

        System.out.println(zoneId.normalized());
    }

    @Test
    public void ZoneOffsetTest() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZoneOffset zoneOffset = ZoneOffset.of("Z");
        System.out.println(zoneOffset.adjustInto(localDateTime));// error

    }

    @Test
    public void DateToLocalDateTimeTest() {

        Date date = new Date();
        Instant instant = date.toInstant();

        // 2020-10-09T14:21:57.960
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // 2020-10-09T06:21:57.960
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, ZoneId.of("UTC+18"));

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = LocalDateTime.now();
        System.out.println(localDateTime3.atZone(ZoneId.of("Z")));

        ZonedDateTime dateTime2 = ZonedDateTime.of(2015, 11, 30, 23, 45, 59, 1234, ZoneId.of("UTC+12"));
        System.out.println(dateTime2.toLocalDateTime());

        System.out.println(dateTime2);
        ZonedDateTime dateTime3 = dateTime2.withZoneSameInstant(ZoneId.of("UTC+15"));
        System.out.println(dateTime3);

        LocalDateTime localDateTime = LocalDateTime.parse("2020-09-15T17:33:45");
        System.out.println(localDateTime);
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(5));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime.toInstant());
        OffsetDateTime offsetDateTime1 = offsetDateTime.withOffsetSameLocal(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime1.toInstant());
        OffsetDateTime offsetDateTime2 = offsetDateTime1.withOffsetSameInstant(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime2);
        System.out.println(offsetDateTime2.toInstant());
    }


}
