package com.test.lambda;

import org.junit.jupiter.api.Test;

public class LambdaTest {
    @Test
    public void test(){
        /*
        * 开启一个线程，这个现成的任务就是打印
        * 非lambda表达式方式实现
        * 要求实现Runable的接口方式来创建多线程
        * */

        TestRunable tr = new TestRunable();
        Thread t = new Thread(tr);
        t.start();
    }
    @Test
    public void test2(){
        //匿名内部类
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类打印结果");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
    @Test
    public void test3(){
        /*
        * 匿名内部类另一种方式
        *
        * */
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类另一种方式");
            }
        });
        t.start();
    }
    @Test
    public void test4(){
        /*
        * 更简洁的匿名内部类
        * */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("更简洁的匿名内部类");
            }
        }).start();
    }
    @Test
    public void test5(){
        /*
        * lambda表达式
        * 箭头函数实现
        * 箭头函数后面的大括号可以省略（如果只有一句代码）
        * */
        new Thread(()->{
            System.out.println("Lambda表达式的打印");
        }).start();
    }
}
class TestRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("打印结果");
    }
}