package com.test.thread;

public class TestRunnable {
    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
        t.start();
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runnable:"+ i);
        }
    }
}