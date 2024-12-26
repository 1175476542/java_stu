package com.test.innerclass;

public class InnerNonStaticClass {
    public static void main(String[] args) {
//        Outer1.Inner1 in = new Outer1.Inner1();//错误的，因为Inner是Outer的非静态成员，所以需要用到Outer的对象
        Outer1 out = new Outer1();
        Outer1.Inner1 in = out.new Inner1();
        Outer1.Inner1 in1 = out.getInner() ;
        in.method();
    }
}
class Outer1{
    private int i;
    private static int j;
    public class Inner1{
        public void method(){
            System.out.println(i);
            System.out.println(j);
        }
    }
    public static void outMethod(){
//        Inner1 inner1 = new Inner1();//错误，静态方法不能访问非静态成员内部类

    }
    public void outMeth(){
        Inner1 inner1 = new Inner1();
        inner1.method();
    }
    public Inner1 getInner(){
        return new Inner1();
    }
}