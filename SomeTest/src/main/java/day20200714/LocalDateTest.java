package day20200714;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());

        List<LocalDate> dates = new ArrayList<>();
        dates.add(now);
        dates.add(LocalDate.of(2018, 02, 17));

        String noticeDate = dates.stream()
                .map(localDate -> localDate.getMonthValue() + "月" + localDate.getDayOfMonth() + "日")
                .reduce((s1, s2) -> s1 + "," + s2).get();

        System.out.println(noticeDate);

        LocalDateTime dateTime = LocalDateTime.parse("2017-09-19 12:45:43", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // 2017-09-19T12:45:43
        System.out.println(dateTime);

        String CNDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒 E"));
        // 2017年09月19日 12时45分43秒 星期二
        System.out.println(CNDateTime);

//        System.out.println(LocalDate.parse("2017-09:09").getMonthValue());   // DateTimeParseException

        System.out.println("输出：" + (new Random().nextBoolean() ? "true" : "false"));
    }

}
