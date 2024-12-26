package com.test.exception;

public class TestTryCatchFinally {
    public static void main(String[] args) {

    }
    public static  String getNum(int a){
        System.out.println(a/0);
        try{
            if (a>0){
                return "正数";
            }else if (a<0){
                return "负数";
            }else return "零";
        }catch (Exception e){
            return "异常";
        }finally {
            return "最终";
        }
    }
}

