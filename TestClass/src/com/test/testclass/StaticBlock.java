package com.test.testclass;

/*

 */
public class StaticBlock {
    public static void main(String[] args) {
        Father1 f = new Son1();
        System.out.println("-----------");
        f.printInfo();
    }
}
class Father1 {
    private static String s = printInfo();
    static {
        System.out.println("1.父类静态代码块");
    }
    public static String printInfo(){
        System.out.println("2.父类静态方法");
        return "1111";
    }
}
class Son1 extends Father1{
    private static String s = printInfo();
    static {
        System.out.println("3.子类静态代码块");
    }
    public static String printInfo(){
        System.out.println("4.子类同名方法");
        return "11";
    }
}
