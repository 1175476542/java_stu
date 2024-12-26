package com.test.thread;

public class TestThreadSecurityLock2 {
    public static void main(String[] args) {
        Ticket1 t = new Ticket1();
        Thread t1 = new Thread(t,"窗口一");
        Thread t2 = new Thread(t,"窗口二");
        Thread t3 = new Thread(t,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket1 implements Runnable{
    private int total = 100000;

    @Override
    public void run() {

        while (true){
            synchronized (this){
                if (total>0){
                    System.out.println(Thread.currentThread().getName()+"卖出一张票");
                    total--;
                    System.out.println("还剩"+total+"张");
                }else break;
            }
        }
    }
}