package com.test.packagetest;

/*
-- 从父类中查找 引用父类的xx
-- 用法：
    -- 1.super.属性
    -- 2.super.方法
    -- 3.super()或super(实参列表)
        -- 必须在父类的首行 ，调用的是父类的有参或无参构造
        -- 如果是顶级父类，调用的是公共父类java.lang.Object类的无参构造
        -- 如果子类构造器没写super()默认存在
        -- 但是如果写了super(实参列表)，那么super()就不会存在
 */
public class TestSuper {
    public static void main(String[] args) {
        B b = new B();
        b.printNum(3);
        b.superF();
    }
}
class A{
    int num = 1;
    public void printF(){
        System.out.println("super父类的方法");
    }
}
class B extends A{
    int num = 2;
    public void printNum(int num){
        System.out.println(num);//3
        System.out.println(this.num);//2
        System.out.println(super.num);//1
    }
    public void printF(){
        System.out.println("super父类被重写的方法");
    }
    public void superF(){
        super.printF();
    }
}
