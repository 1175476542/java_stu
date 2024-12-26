package com.test.innerclass;
import com.test.innerclass.Outer.Inner;

public class InnerMenberClass {
    public static void main(String[] args) {
        Outer.Inner.method();
        Inner.method();
        Inner inner = new Inner();
        Outer.Inner inner1 = new Outer.Inner();
        inner1.test();
//        Inner.test();//错误，静态方法中不能通过类名.引用非静态变量，要通过对象名.
        inner.test();
    }
}
class Outer{
    private int i;
    private static int j;
    static class Inner{
        public void test(){
//            System.out.println(i); //错误，静态内部类中只能使用外部类的静态变量
            System.out.println(j);
        }
        public static void method(){

        }
    }
    class Nei{

    }
}
