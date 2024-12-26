package com.test.interfacetest;

public class TestStringCompare {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Haha";
        if (s1.compareTo(s2)>0){
            System.out.println("s1>s2");
        }else if (s1.compareTo(s2)>0){
            System.out.println("s1<s2");
        }else {
            System.out.println("s1=s2");
        }
    }
}
