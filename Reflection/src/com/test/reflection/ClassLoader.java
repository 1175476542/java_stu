package com.test.reflection;

public class ClassLoader {
    public static void main(String[] args) {
        //类加载过程概述
//        D d = new D();//这里会触发类的初始化
        System.out.println(D.NUM);//只打印，不会触发类的初始化
        System.out.println(F.num);
        F.test();
        A[] a = new A[10];
    }
}
class D{
    public static final int NUM = 10;//去掉final会触发类的初始化
    static {
        System.out.println("D类初始化");
    }
}
class E{
    public static int num = 10;
    static {
        System.out.println("E父类的初始化");
    }
    public static void test(){
        System.out.println("E静态方法不会导致F子类初始化");
    }
}
class F extends E{
    static {
        System.out.println("F子类的初始化");
    }

}
class A{
    static {
        System.out.println("A类的初始化");
    }
}
