package com.test.thread;

public class TestLockFunc {
    public static void main(String[] args) {
        TicketSell ts = new TicketSell("窗口一");
        TicketSell ts1 = new TicketSell("窗口二");
        TicketSell ts2 = new TicketSell("窗口三");
        ts.start();
        ts1.start();
        ts2.start();
    }
}
class TicketSell extends Thread{
    private static int total = 1000;
    public TicketSell(){

    }
    public TicketSell(String name){
        super(name);
    }

    @Override
    public void run() {
        while(total>0){
            sellTicket();
        }
    }
    public static synchronized void sellTicket(){
        if (total>0){
            System.out.println(Thread.currentThread().getName()+"卖出一张票");
            total--;
            System.out.println("还剩"+total+"张票");
        }
    }
}