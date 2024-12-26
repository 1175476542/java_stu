package com.test.testclass;
//类的第三个组成部分
    /*
        构造器，也称为构造方法，因为
        （1）他长得像方法
        （2）他编译后是一个实例初始化方法
        1.构造器的作用
        （1）构造对象，创建对象
            和new一起使用，每次调用它都是在创造一个新的对象
        2.构造器的特点
            （1）所有类都有构造器
            （2）如果一个类没有显示声明构造器，那么编译器将会生成一个默认的无参构造
            （3）如果一个类显示声明了构造器，那么编译器将不会在生成默认的无参构造了

        习惯上写法
            属性
            构造器
            方法
     */
public class ClassConstructor {
    public static void main(String[] args) {
        Xc xc = new Xc();
        Xc xc1 = new Xc("集景");
    }
}
class Xc{
    private String unit;
    public Xc(){
        System.out.println("集醒");
    }
    public Xc(String unit){
        this.unit = unit;
        System.out.println(unit);
    }
}
