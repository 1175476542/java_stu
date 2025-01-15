package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionReference {
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        list.forEach((num)->{
//            System.out.println(num);
//        });//等价于下文
        list.forEach(System.out::println);
    }
    @Test
    public void test2(){
        /*
        * Math.random返 回的是double类型
        * Stream是泛型，可以限定为Double
        * */
        Stream<Double> stream = Stream.generate(()->{return Math.random();});
        Stream<Double> stream1 = Stream.generate(()-> Math.random());//等价于下文
        Stream<Double> stream2 = Stream.generate(Math::random);
    }
    @Test
    public void test3(){
        String[] arr = {"java","hello","Java","world"};
        /*
        * 这里的
        * Comparator<String>接口 int compare(String s1,String s2)
        * String类的              int compareToIgnoreCase(String str)此处，s1正好是调用compareToIgnoreCase的对象，s2是给他的参数
        * */
        Arrays.sort(arr,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4(){
        /*
        * Lambda表达式也可以用于给SAM的接口的变量赋值
        * 如何实现Supplier<T>接口的抽象方法T get()
        * 例如：创建一个String的空对象
        * */
        Supplier<String> s1 = ()->new String();
        Supplier<String> s = String::new ;
    }
}
