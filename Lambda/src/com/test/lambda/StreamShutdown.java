package com.test.lambda;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamShutdown {
    @Test
    public void test(){
        Stream.of(1,2,3,4,5,6)
                .forEach(System.out::println);
    }
    @Test
    public void test2(){
        long count = Stream.of(1,2,3,4,5,6)
                .count();
        System.out.println(count);
    }
    @Test
    public void test3(){
        boolean result = Stream.of(1,3,5,7,9)
                .allMatch(t->t%2!=0);
        System.out.println(result);
    }
    @Test
    public void test4(){
        boolean result = Stream.of(1,3,6,7,9)
                .anyMatch(t->t%2!=0);
        System.out.println(result);
    }
    @Test
    public void test5(){
        boolean result = Stream.of(1,3,6,7,9)
                .noneMatch(t->t%2!=0);
        System.out.println(result);
    }
    @Test
    public void test6(){
        Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
                .filter(t->t%3 == 0)
                .findFirst();
        System.out.println(opt);
    }
    @Test
    public void test7(){
        Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
                .filter(t->t%3 == 0)
                .findAny();
        System.out.println(opt);
    }
    @Test
    public void test8(){
        Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
                        .max((t1,t2)->Integer.compare(t1,t2));
        System.out.println(opt);
    }
    @Test
    public void test9(){
        Optional<Integer> reduce = Stream.of(1,2,3,4,5,6)
                .reduce((t1,t2)->t1+t2);
        System.out.println(reduce);
    }
    @Test
    public void test10(){
        List list = Stream.of(1,2,3,4,5,6)
                .filter(t->t%2 == 0)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
