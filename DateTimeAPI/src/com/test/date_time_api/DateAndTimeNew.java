package com.test.date_time_api;



import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateAndTimeNew {
    public static void main(String[] args) {

    }
}
class Test2{
    @Test
    public void test1(){
        LocalDate ld = LocalDate.now();
        System.out.println(ld);//当前日期
        LocalTime lt = LocalTime.now();
        System.out.println(lt);//当前时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);//当前日期时间
    }
    @Test
    public void test2(){
        LocalDate ld = LocalDate.of(2022,6,22);
        System.out.println(ld);
        System.out.println(ld.getDayOfYear());
        LocalDate ld1 = ld.plusDays(333);
        System.out.println(ld1);
    }
    @Test
    public void test3(){
        LocalDate now = LocalDate.now();
        LocalDate before = now.minusYears(1);
        System.out.println(now.isLeapYear());
        System.out.println(before.isLeapYear());
    }
    @Test
    public void test4(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        DateTimeFormatter dtf1 =DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str = dtf.format(now);
        String str2 = dtf1.format(now);
        String str4 = dtf3.format(now);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str4);
    }
}