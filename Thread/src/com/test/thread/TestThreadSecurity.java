package com.test.thread;

public class TestThreadSecurity {
    public static void main(String[] args) {
        Ticket t1 = new Ticket("窗口一");
        Ticket t2 = new Ticket("窗口二");
        Ticket t3 = new Ticket("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket extends Thread {
    private static int total = 1000;
    private static Object lock = new Object();
    public Ticket(){

    }
    public Ticket(String name){
        super(name);
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (total > 0) {
                    System.out.println(getName() + "买了一张票");
                    total--;
//                    try{
//                        sleep(100);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
                    System.out.println("还剩" + total + "张票");
                }else break;
            }
        }
    }
}
