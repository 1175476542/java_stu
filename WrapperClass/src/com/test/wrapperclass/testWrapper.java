package com.test.wrapperclass;


import org.junit.jupiter.api.Test;

public class testWrapper {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        int a = 1;
        double j = 1;
        System.out.println(i == a);//先把i拆箱然后比较两者的int值结果为true
        System.out.println(i == j);//先把i拆箱,然后把i自动类型转换成double，再比较两个double结果为true

    }

}
class test{
    @Test
    public void test1(){
        int num = Integer.parseInt("1");
        System.out.println(num);
//        int num1 = Integer.parseInt("1.1");//错误的，只能用对应类型转换
//        System.out.println(num);
        double num1 = Double.parseDouble("1.1");
        System.out.println(num1);
    }
    @Test
    public void test2(){
        int a = Integer.valueOf("1");//先把valueOf转换为Integer，然后在转换为int类型
        double b = Double.valueOf("2");
        System.out.println(a);
        System.out.println(b);
    }
    @Test
    public void test3(){
        System.out.println(Integer.toBinaryString(10));//转二进制
        System.out.println(Integer.toOctalString(10));//转八进制
        System.out.println(Integer.toHexString(10));//转十六进制
    }
    @Test
    public void test4(){
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    @Test
    public void test5(){
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('a'));
    }
    @Test
    public void test6(){
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
    }

}

