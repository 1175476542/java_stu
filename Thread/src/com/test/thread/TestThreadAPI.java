package com.test.thread;

import org.junit.jupiter.api.Test;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class TestThreadAPI {
    public static void main(String[] args) {
//        Thread t = Thread.currentThread();
//        System.out.println(t.getName());
//        MyRun my = new MyRun();
//        System.out.println(my.getName());
//        Thread t1 = new Thread("线程3");
//        System.out.println(t1.getName());
//        MyRun m = new MyRun();
//        m.start();
//        try{
//            sleep(3000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        m.interrupt();
        MyRunnable1 m = new MyRunnable1();
        Thread t = new Thread(m);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:"+i);
            if (i == 3){
                try{
                    t.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

class TestMethod{
    @Test
    public void sleepTest(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try{
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Test
    public void getTomorrowTime(){
        try{
            sleep(1000*60*60*240);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
    }
}
class MyRun extends Thread{


    public MyRun() {
    }

    public MyRun(String name) {
        super(name);
    }
    public void run(){
        System.out.println("自定义线程");
        try{
            sleep(10000);
        }catch (InterruptedException i){
            i.printStackTrace();
        }
        System.out.println("自定义线程被打断");
    }

}
class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i >0 ; i--) {
            System.out.println("run:"+i);
            try{
                sleep(1000);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}