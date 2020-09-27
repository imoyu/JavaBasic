package day20200927;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) {
        int endMonth = 202009;
        // 定位到目标时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, endMonth / 100);
        calendar.set(Calendar.MONTH, endMonth % 100 - 1);

        calendar.add(Calendar.MONTH, 1);
        int em = calendar.get(Calendar.MONTH) + 1;
        String emStr = em < 10 ? "0" + em : "" + em;
        String timeEnd = String.format("%s-%s-01 00:00:00", calendar.get(Calendar.YEAR), emStr);


        DateTimeFormatter displayedDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        if (now.getYear() == endMonth / 100 && now.getMonth().getValue() == endMonth % 100) {
            timeEnd = now.plusDays(1).format(displayedDateFormat) + " 00:00:00";
        }
        System.out.println(timeEnd);

    }

}
