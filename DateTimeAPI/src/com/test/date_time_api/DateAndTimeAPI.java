package com.test.date_time_api;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateAndTimeAPI {
    public static void main(String[] args) {

    }
}
class Test1{
    @Test
    public void test1(){
        Date t = new Date();
        System.out.println(t);
    }
    @Test
    public void test2(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
    @Test
    public void test3(){
        long time = System.currentTimeMillis();
        Date d = new Date();
        System.out.println("Date转为："+d.getTime());
        System.out.println("time转为"+new Date(time));
    }
    @Test
    public void  test5(){
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);
        int month = c.get(Calendar.MONTH);
        System.out.println(month);
    }
    @Test
    public void test6(){
//        String[] all = TimeZone.getAvailableIDs();
//        for (int i = 0; i < all.length; i++) {
//            System.out.println(all[i]);
//        }
        TimeZone t = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar c = Calendar.getInstance(t);
        System.out.println(c);
    }
    @Test
    public void  test7(){
        Date d = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str = sdf.format(d);
        System.out.println(str);
    }
    @Test
    public void test8() throws ParseException {
        String str = "2024年12月26日 00:33:19";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d = sdf.parse(str);
        System.out.println(d);
    }
}