package com.test.string;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class TestStringCompare {
    public static void main(String[] args) {

    }
}
class TestClass{
    @Test
    public void Test1(){
        String a = "hello";
        String b = "hello";
        System.out.println(a == b);//true
    }
    @Test
    public void Test2(){
        String a = new String("hello");
        String b = "hello";
        System.out.println(a == b);//false
    }
    @Test
    public void Test3(){
        String a = new String("hello");
        String b = new String("hello");
        System.out.println(a == b);//false
    }
    @Test
    public void Test4(){
        String a = new String("hello");
        String b = new String("hello");
        System.out.println(a.equals(b));//true
    }
    @Test
    public void Test5(){
        String a = new String("hello");
        String b = new String("Hello");
        System.out.println(a.equalsIgnoreCase(b));//true
    }
    @Test
    public void Test6(){
        String a = new String("hello");
        String b = new String("Hello");
        if (a.compareTo(b)>0){
            System.out.println(a+"大");
        }else {
            System.out.println(b+"大");
        }
        //        System.out.println(a.equalsIgnoreCase(b));//true
    }
    @Test
    public void Test7(){
        String[] s = {"Sirius", "Yes", "hello", "Hello", "java"};
        Arrays.sort(s, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                return s1.compareToIgnoreCase(s2);
            }
        });
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
    @Test
    public void Test8(){
        String[] s = {"张三", "李四", "王五", "赵六", "钱七"};
        Arrays.sort(s, Collator.getInstance());
        System.out.println(Arrays.toString(s));
    }
    public void Test9(){
        String[] s = {"张三", "李四", "王五", "赵六", "钱七"};
        Arrays.sort(s, Collator.getInstance(Locale.CHINA));
        System.out.println(Arrays.toString(s));
    }
}


