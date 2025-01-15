package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> s = list.stream();
//        s.forEach(System.out::println);
        s.forEach((num)->{
            System.out.println(num);
        });
    }
    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        //        s.forEach(System.out::println);
        stream.forEach((num)->{
            System.out.println(num);
        });
    }
    @Test
    public void test3(){
        //产生一个有限流
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        stream.forEach(System.out::println);
    }
    @Test
    public void test4(){
        //产生一个无限流
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }
    @Test
    public void test5(){
        Stream<Integer> stream = Stream.iterate(1,(num)->{
            return num += 2;
        });
        stream = stream.limit(10);
        stream.forEach(System.out::println);
    }
}
