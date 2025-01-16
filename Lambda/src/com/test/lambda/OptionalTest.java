package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test(){
        String s = "hello world";
        Optional<String> opt = Optional.of(s);
        System.out.println(opt);
    }
    @Test
    public void test2(){
        String s = null;
        Optional<String> opt = Optional.ofNullable(s);
        String s1 = opt.orElse("结果为空");//如果是空的，返回orElse括号内的内容
        System.out.println(s1);
    }
    @Test
    public void test3(){
        String s = null;
        Optional<String> opt = Optional.ofNullable(s);
        String s1 = opt.orElseGet(String::new);
        System.out.println(s1);
    }
    @Test
    public void test4(){
        String s = null;
        Optional<String> opt = Optional.ofNullable(s);
        String s1 = opt.orElseThrow(()->new RuntimeException("值不存在"));
        System.out.println(s1);
    }
}
