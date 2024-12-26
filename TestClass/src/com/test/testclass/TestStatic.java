package com.test.testclass;

import java.util.Scanner;

/*
## static
#### static 也是一种修饰符
        -- 1.意思：静态的
        -- 2.可以修饰什么
            --（1）方法
            --（2）成员变量
            --（3）内部类
            --（4）代码块
            - ！不能修饰局部变量
        -- 3.修饰后有什么不同
            -- (1)方法：
                -- ①这个方法对于其他类来说可以用 类名.方法 进行调用，当然也可以使用“对象名.方法”进行调用，推荐使用“类名.方法”
                - ②静态方法中是不允许使用this、super、对本类的非静态属性、非静态方法的使用代码的
            - （2）成员变量
                - ①用static修饰的成员变量的值，表示是这个类型的所有对象共享的
                - ②用static修饰的成员变量的值存在方法区
                - ③用static修饰的成员变量的getter、setter也是静态的
                - ④并且在方法中有局部变量与static修饰的成员变量命名相同时，在静态变量前加“类名.”进行区别
            # 结论：静态的用“类名.”，非静态的用“对象名.”
 */
public class TestStatic {
//    static final int i = 0;
    private int num;//非静态变量
    public int getNum(){//非静态方法
        return num;
    }
    public static void main(String[] args) {
        int row;
        int column;
        char dot;

        java.util.Scanner input= new Scanner(System.in);
        System.out.println("请输入行数");
        row = input.nextInt();
        System.out.println("请输入列数");
        column = input.nextInt();
        System.out.println("请输入打印的图形");
        dot = input.next().charAt(0);
        GraphicTools.printRectangle(dot,row,column);//其他类可以通过类名.方法名调用静态方法
        //以下全报错
//        System.out.println(this.num);
//        System.out.println(num);
//        System.out.println(getNum());
        System.out.println("--------------");
        Account a1 = new Account();
        Account a2 = new Account();
        System.out.println("a1的rate是："+a1.rate+",a1的balance是："+a1.balance);
        System.out.println("a2的rate是："+a2.rate+",a2的balance是："+a2.balance);
        a2.balance = 2000;
        a2.rate = 0.45;
        System.out.println("a1的rate是："+a1.rate+"a1的balance是："+a1.balance);
        System.out.println("a2的rate是："+a2.rate+"a2的balance是："+a2.balance);
    }
}
class GraphicTools{
//    int row;
//    int column;
//    char dot;
    public static void printRectangle(char dot,int row,int column){



        for (int i = 0;i<row;i++){
            for (int j = 0;j<column;j++){
                System.out.print(dot);
            }
            System.out.println();
        }
    }

}

class Account{
    static double rate = 0.35;
    double balance = 1000;
}
