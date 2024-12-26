package com.test.thread;

public class TestThread {
    public static void main(String[] args) {
        Thread m = new MyThread();
        m.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:"+i);
        }
    }
}
class MyThread extends Thread{
    public void run(){//必须重写Thread的run方法
        for (int i = 0; i < 100; i++) {
            System.out.println("myMethod:" + i);
        }
    }
}
