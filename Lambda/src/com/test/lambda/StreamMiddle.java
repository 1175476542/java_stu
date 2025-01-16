package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMiddle {
    @Test
    public void test1() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream = stream.filter(t -> t % 2 == 0);//必须要接收
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream.of(1, 2, 3, 4, 5, 6).filter(t -> t % 2 == 0).forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream.of(1, 2, 3, 5, 4, 6, 5, 87, 9, 5, 65, 5, 5, 51, 93).distinct().filter(t -> t % 2 == 0).forEach(System.out::println);
        Stream.of(1, 2, 3, 5, 4, 6, 5, 87, 9, 5, 65, 5, 5, 51, 93).distinct().forEach(System.out::println);
    }

    @Test
    public void test4() {
        Stream.of(1, 3, 5, 35, 5, 6, 44, 5, 506, 58, 22, 5, 9, 3, 2, 2, 1, 5, 3, 5, 227, 9, 6).
                distinct().
                filter(t -> t % 2 != 0).
                limit(3).forEach(System.out::println);
    }

    @Test
    public void test5() {
        Stream.of(1, 3, 5, 35, 5, 6, 44, 5, 506, 58, 22, 5, 9, 3, 2, 2, 1, 5, 3, 5, 227, 9, 6).
                distinct().
                filter(t -> t % 2 != 0).
                skip(3).
                limit(3).forEach(System.out::println);
    }
    @Test
    public void test6(){
        long count = Stream.of(1, 3, 5, 35, 5)
                .distinct()
                .peek(System.out::println)
                .count();
        System.out.println(count);
    }
    @Test
    public void test7(){
        Stream.of(1, 3, 5, 35, 5, 6, 44, 5, 506, 58, 22, 5, 9, 3, 2, 2, 1, 5, 3, 5, 227, 9, 6)
                //找最大的三个不重复的
                .distinct()
//                .sorted()//这是按照从小到大排序
                .sorted((t1,t2 )->- Integer.compare(t1,t2))
                .limit(3)
                .forEach(System.out::println);
    }
    @Test
    public void test8(){
        Stream.of(1,2,3,4,5)
                .map((t)->{
                    return t*2;
                })
                .forEach(System.out::println);
    }
    @Test
    public void test9(){
        String[] arr = {"hello","world","java"};
        Stream<String> flatMap = Arrays.stream(arr)
                .flatMap(t->Stream.of(t.split("|")));
        flatMap.forEach(System.out::println);
    }
}
