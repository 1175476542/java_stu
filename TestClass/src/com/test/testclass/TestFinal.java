package com.test.testclass;

/*
final:修饰符的一种
    -- 1.意思：最终的
    -- 2.final可以修饰：类（内部类、外部类）、变量（成员变量（类变量、实例变量）、局部变量）、方法（静态方法、非静态方法）
    -- 3.有什么不同
        -- （1）final修饰类后不能被继承，俗称太监类。例如String、System、Math
        -- （2）修饰方法时，表示方法不能被重写，但是可以被继承
        -- （3）final修饰变量的时候，表示不能被修改，我们成为常量
            -- 常量分为字面常量（'hello'）和final修饰的量
 */
public class TestFinal {
    public static void main(String[] args) {
        Circle3 c = new Circle3();


    }

    public static void change(final Circle3 c) {//表示圆对象不能被修改
//        c = new Circle3();//错误
        //但是半径可以改，因为半径没用final修饰
        c.radius = 2;
    }
}

class Father {
    public void test() {

    }

    public final void test2() {

    }
}

class Son extends Father {
    public void test() {
    }
//    public void test2(){}//报错
}

final class Test {
    public void test2() {
    }
}
//class Test2 extends Test{}//报错

class Circle3 {
    double radius;
}
