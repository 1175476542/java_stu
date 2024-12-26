package com.test.thread;

public class TestLockRunnable {
    public static void main(String[] args) {

        TicketSell1 ts1 = new TicketSell1();
        Thread t1 = new Thread(ts1,"窗口一");
        Thread t2 = new Thread(ts1,"窗口二");
        Thread t3 = new Thread(ts1,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
class TicketSell1 implements Runnable{
    private static int total = 1000;


    @Override
    public void run() {
        while(total>0){
            sellTicket();
        }
    }
    public synchronized void sellTicket(){
        if (total>0){
            System.out.println(Thread.currentThread().getName()+"卖出一张票");
            total--;
            System.out.println("还剩"+total+"张票");
        }
}
}
