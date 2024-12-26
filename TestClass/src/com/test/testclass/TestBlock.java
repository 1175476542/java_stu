package com.test.testclass;

/*
 * 1、类的成员：
 * （1）属性：成员变量
 * （2）方法：成员方法
 * （3）构造器
 * （4）代码块
 * ①非静态代码块
 * ②静态代码块：后面讲，和static一起说
 *
 * 2、非静态代码块
 * （1）声明的格式：
 * 【修饰符】 class 类名{
 * 		{
 * 			非静态代码块;
 * 		}
 * }
 *
 * （2）非静态代码块中的代码什么时候执行？
 * ①在“每次”创建对象的时候执行
 * ②比构造器早
 *
 * （3）实例初始化过程：创建对象时，为对象进行初始化的操作
 * ①为成员变量显式赋值
 * ②执行非静态代码块
 * ③执行构造器
 *
 * Java编译器其实，会把这三个部分的代码，合成一个叫做<init>(【形参列表】)实例初始化方法
 * 即编译后的.class字节码信息中，是没有构造器这个概念。
 *
 * <init>(【形参列表】)实例初始化方法的代码就是由三个部分组成：
 * ①成员变量显式赋值的代码
 * ②非静态代码块中的代码
 * ③构造器中的代码
 *
 * 其中的①和②按顺序执行，而③一定是它们当中的最后执行。
 *
 * 而且，有几个构造器，就会有几个实例初始化方法。那么当你创建对象的时候，调用对应的构造器时，其实执行的是对应的实例初始化方法<init>(【...】)
 */
public class TestBlock {
    public static void main(String[] args) {
/*		MyClass my1 = new MyClass();//调用无参构造
		MyClass my2 = new MyClass("atguigu");//调用有参构造
*/

        Demo d1 = new Demo();//调用无参构造，本质上是调用<init>()实例初始化方法
        Demo d2 = new Demo("atguigu");//调用有参构造，本质上是调用<init>(形参列表)实例初始化方法
    }
}
class MyClass{
    private String str = "hello";//显式赋值

    public MyClass(){
        System.out.println("无参构造");
    }
    public MyClass(String str){
        this.str = str;
        System.out.println("有参构造");
    }

    {
        System.out.println("非静态代码块");
    }
}

class Demo{
    {
        System.out.println("非静态代码块1");
    }

    private String str = assign();//调用方法，来为str进行显式赋值

    public Demo(){
        System.out.println("无参构造");
    }
    public Demo(String str){
        this.str = str;
        System.out.println("有参构造");
    }

    {
        System.out.println("非静态代码块2");
    }

    public String assign(){
        System.out.println("assign方法");
        return "hello";
    }
}