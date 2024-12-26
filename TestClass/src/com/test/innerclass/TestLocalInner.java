package com.test.innerclass;

public class TestLocalInner {
    public static void main(String[] args) {
        Outer2 out = new Outer2();
        out.test();
        Object obj = out.test();
        System.out.println(obj);
    }
}
class Outer2{
    private int i = 0;//成员变量，实例变量，非静态成员变量
    private static int j = 1;//成员变量，类变量，静态变量
    public Object test(){
        class Inner2{
            public void method(){
                final int a = 10;//局部变量
                System.out.println(i);
                System.out.println(j);
                System.out.println(a);
            }
        }
        Inner2 in = new Inner2();
        in.method();
        return in;
    }
//    public void method(){
//        //        Inner2 in = new Inner2;//局部的有作用域
//
//    }
    public static void method(){
//        System.out.println(i);//错误，静态方法不能访问非静态变量
        System.out.println(j);
    }

}
