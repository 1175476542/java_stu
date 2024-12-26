package com.test.testclass;

public class MethReload {
    //方法重载
    public static void main(String[] args) {
        System.out.println(max(1,3));
        System.out.println(max(3.4,3.5));
        System.out.println(max(1,2,3));
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static double max(double a,double b){
        return  a>b?a:b;
    }
    public static int max(int a,int b, int c){
        return max(max(a,b),c);
    }
}
