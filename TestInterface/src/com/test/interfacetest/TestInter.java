package com.test.interfacetest;

public class TestInter {
    public static void main(String[] args) {
        MyInter.StaInter();
        Imp1 i = new Imp1();
        i.DefaiInter();
        Son s = new Son();
        s.test();
    }
}
interface MyInter{
    public static void StaInter(){
        System.out.println("静态接口");
    }
    void fun();
    public default void DefaiInter(){
        System.out.println("默认接口");
    }
}
class Imp1 implements MyInter{
    public void fun(){
        System.out.println("aaaa");
    }
}
class Imp2 implements MyInter{
    public void fun(){
        System.out.println("aaaa");
    }
}
class Imp3 implements MyInter{
    public void fun(){
        System.out.println("bbbb");
    }

    @Override
    public void DefaiInter() {
        System.out.println("重写接口的默认方法");//重写接口的默认方法
    }
}
interface A1{
    public default void test(){
        System.out.println("aaa");
    }
}
interface B1{
    public default void test(){
        System.out.println("bbb");
    }
}
interface C1 extends A1,B1{
    public default void test(){
        A1.super.test();
    }
}

class Father {
    public void test(){
        System.out.println("父类");
    }
}
interface D{
    public default void test(){
        System.out.println("接口D");
    }
}
class Son extends Father implements D{
    @Override
    public void test() {
        super.test();
    }
}

