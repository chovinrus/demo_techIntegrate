package demo.zjm._05常用类._06新日期时间API;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class Main {
    public static void main(String[] args) {
        LocalDate now0 = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now0);
        System.out.println(now1);
        System.out.println(now2);
        //2022-03-24
        //12:39:08.886
        //2022-03-24T12:39:08.886

        //指定具体时间日期并获得实际值
        LocalDateTime of0 = LocalDateTime.of(2019, 3, 2, 2, 3, 0);
        System.out.println(of0);//2019-03-02T02:03
        System.out.println(of0.getHour());//2

        //新API避免了Calendar的可变性
        LocalDateTime localDateTime = of0.withHour(3);
        System.out.println(of0.getHour());//2
        System.out.println(localDateTime.getHour());//3
        System.out.println(of0.plusDays(2).getDayOfMonth());//4

        //格式化可以是标准化格式，本地格式，自定义格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String format = dateTimeFormatter.format(now2);
        System.out.println(format);//2022-03-24T13:40:58.777
        TemporalAccessor parse = dateTimeFormatter.parse(format);
        System.out.println(parse);//{},ISO resolved to 2022-03-24T13:48:13.877
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String format1 = dateTimeFormatter1.format(now2);
        System.out.println(format1);//22-3-24 下午1:48
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format2 = dateTimeFormatter2.format(now2);
        System.out.println(format2);//2022-03-24 01:51:27


        //instant
        Instant now = Instant.now();
        System.out.println(now);//2022-03-24T04:53:39.120Z格林威治时间
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2022-03-24T12:53:39.120+08:00北京时间
        System.out.println(now.toEpochMilli());//时间戳
        Instant instant = Instant.ofEpochMilli(1648097715158l);
    }
}
