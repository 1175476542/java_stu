package com.test.exception;

public class TestThrows {
    public static void main(String[] args) {
        try{
            divide(5,3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static double divide(double a,double b) throws ArithmeticException,RuntimeException{
        System.out.println(a/b);
        return a/b;
    }
}
