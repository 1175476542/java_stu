package com.test.exception;

import java.util.Scanner;

public class TestException {
    public static void main(String[] args) {
        try {
            test();
        }catch (Exception e){
            System.out.println("你的输入有误");
        }
    }

    public static void test() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入一个整数：");

            int a = input.nextInt();
        } catch (ArrayIndexOutOfBoundsException e) {//数组异常没找到，找上级test()
            System.out.println("你的输入有误");
        }
    }
}
