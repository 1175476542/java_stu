package com.test.lambda;

public class TestDefineFunctionalInterface {
    public static void main(String[] args) {
        /*
        * 1.抽象方法：int cal(int a,int b);
        * 2. 如何实现抽象方法，例如：求a+b的和
        * */
        getSum(1,2,(int a,int b)->{return a+b;});
    }

    public static void getSum(int a,int b,CalTest tool){
        int cal = tool.Cal(a, b);
        System.out.println(cal);
    }
}
@FunctionalInterface
interface CalTest{
    int Cal(int a,int b);
}
