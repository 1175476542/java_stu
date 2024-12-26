//package com.atguigu.test03;
package Test_Array;
/*
 * static：静态
 * 3、修饰后有什么不同？
 * （1）方法：我们称为“静态方法”或“类方法”
 * （2）成员变量：称为“类变量、静态变量”
 * （3）内部类：后面讲
 * （4）代码块
 *
 * 非静态代码块：
 * 【修饰符】 class 类{
 * 		{
 * 			非静态代码块
 * 		}
 * }
 *
 * 静态代码块：
 * 【修饰符】 class 类{
 * 		static{
 * 			静态代码块
 * 		}
 * }
 *
 * 特点：
 * （1）每一个类的静态代码块只会执行一次
 * （2）静态代码块在第一次使用这个类之前执行，即在类初始化时执行。
 *
 *
 * 4、类初始化即执行类初始化方法：<clinit>()
 * 类初始化方法，一个类只有一个。它也是有编译器编译生成的，由两部分代码组成：
 * （1）静态变量的显式赋值代码
 * （2）静态代码块的代码
 * 其中（1）和（2）是按照顺序执行
 *
 * 回忆：实例初始化方法<init>()或<init>(形参列表)
 * 一个类可能有好几个实例初始化方法，有几个构造器就有几个实例初始化方法，它们由编译器根据：
 * ①成员变量的显式赋值代码
 * ②非静态代码块代码
 * ③构造器的代码
 *
 * initialize：初始化
 * class initialize：类初始化
 */
public class TestStatic2 {
    static{
        System.out.println("TestStatic2静态代码块");
    }
    public static void main(String[] args) {
		/*MyClass.test();
		MyClass.test();
		MyClass.test();
		MyClass.test();*/

/*		MyClass my1 = new MyClass();
		MyClass my2 = new MyClass();
		MyClass my3 = new MyClass();*/

        Demo1 d = new Demo1();//现在第一次使用Demo类，用它创建一个对象时，会导致Demo类的初始化
    }
}

class MyClass{
    static{
        System.out.println("MyClass静态代码块");
    }

    public static void test(){
        System.out.println("静态方法");
    }

}

class Demo1{
    static{
        System.out.println("（1）Demo的静态代码块1");
    }
    private static String info = assign();
    static{
        System.out.println(info);
        System.out.println("（2）Demo的静态代码块2");
    }
    public static String assign(){
        System.out.println(info);
        System.out.println("（3）assign()方法");
        return "hello";
    }
}