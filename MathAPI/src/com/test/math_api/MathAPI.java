package com.test.math_api;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MathAPI {
    public static void main(String[] args) {

    }
}
class Test1{
    @Test
    public void test1(){
        System.out.println(Math.PI);
        System.out.println(Math.sqrt(4));
        System.out.println(Math.pow(2,10));
        System.out.println(Math.max(3,5));
        System.out.println(Math.min(3,5));
    }
    @Test
    public void test2(){
        System.out.println(Math.ceil(2.1));
        System.out.println(Math.floor(2.1));
        System.out.println(Math.round(2.1));
        System.out.println();


        System.out.println(Math.ceil(2.6));
        System.out.println(Math.floor(2.6));
        System.out.println(Math.round(2.6));
        System.out.println();


        System.out.println(Math.ceil(-2.1));
        System.out.println(Math.floor(-2.1));
        System.out.println(Math.round(-2.1));
        System.out.println();


        System.out.println(Math.ceil(-2.6));
        System.out.println(Math.floor(-2.6));
        System.out.println(Math.round(-2.6));
        System.out.println();
    }
    @Test
    public void test3(){
        BigInteger big = new BigInteger("11111111111111111111111111111");
        BigInteger big2 = new BigInteger("22222222222222222222222222222");
        //不能直接运算
        System.out.println(big2.add(big));
        System.out.println(big2.subtract(big));
        System.out.println(big2.multiply(big));
        System.out.println(big2.divide(big));
        System.out.println(big2.remainder(big));
    }
    @Test
    public void test4(){
        BigDecimal big = new BigDecimal("11.534111111111111111111111");
        BigDecimal big2 = new BigDecimal("245322.22452222222222222222");
        //不能直接运算
        System.out.println(big2.add(big));
        System.out.println(big2.subtract(big));
        System.out.println(big2.multiply(big));
        //Non-terminating decimal expansion
        //除不尽，报异常，需要用到其他参数
//        divide(BigDecimal divisor,int scale,int roundingMode);
        //                  被除数         保留几位    怎么保留（向上取，还是向下）
//        System.out.println(big2.divide(big));
        System.out.println(big2.divide(big,10,BigDecimal.ROUND_CEILING));
        System.out.println(big2.remainder(big));
    }
}