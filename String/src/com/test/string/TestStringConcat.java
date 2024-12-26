package com.test.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestStringConcat {
    public static void main(String[] args) {

    }
}

class Test2 {
    @Test
    public void Test1() {
        String str = new String("hello");//这是两个字符串对象
        //常量池中有一个hello，堆中有一个String对象，堆中的字符串对象char[]的value数组，
        // 指向常量池中"hello"的char[]的value
    }

    @Test
    public void Test2() {
        String s1 = "hello";
        String s2 = "java";
        String s3 = "hellojava";
        String s4 = s1 + "java";
        String s5 = s1 + s2;
        String s6 = "hello" + "java";
        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//true
    }

    @Test
    public void Test3() {
        final String s1 = "hello";
        final String s2 = "java";
        String s3 = "hellojava";
        String s4 = s1 + "java";
        String s5 = s1 + s2;
        String s6 = "hello" + "java";
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//true
        System.out.println(s3 == s6);//true
    }

    @Test
    public void Test4() {
        String s1;//局部变量未初始化
        String s2 = null;
        String s3 = "";
        String s4 = new String();
        String s5 = new String("");
//        System.out.println(s1);//无法使用
//        System.out.println(s2.length());//空指针异常
        System.out.println(s3.length());//0
        System.out.println(s4.length());//0
        System.out.println(s5.length());//0
    }
@Test
    public void Test5() {
        String s1;//局部变量未初始化
        String s2 = null;
        String s3 = "";
        String s4 = new String();
        String s5 = new String("");
        System.out.println(test(s2));
        System.out.println(test1(s3));
        System.out.println(test2(s4));
        System.out.println(test4(s5));
    }

    public boolean test(String str) {
        if (str != null && str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean test1(String str) {
        if (str != null && str.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean test2(String str) {
        if ("".equals(str)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean test4(String str) {
        if (str != null && str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    @Test
    public void test6(){
        String str = "  hello  java   ";
        str = str.trim();//产生了新的字符串对象，所以需要接受
        System.out.println(str);
    }
    @Test
    public void test7(){
        String str = "HelloJava";
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='A'&&chars[i]<='Z'){
                count++;
            }

        }
        System.out.println(count);

    }
    @Test
    public void test8(){
        String str = "hello";
        System.out.println(str.charAt(0));
    }
    @Test
    public void test9(){
        char[] chars = {'h','e','l','l','o'};
        String str1 =new String(chars,1,3);
        System.out.println(str1);
    }
    @Test
    public void test10(){
        String str = "java";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
     }
     @Test
    public void test11(){
        String str  = "hello.java.txt";
         System.out.println(str.contains("."));
         System.out.println(str.indexOf("."));
         System.out.println(str.lastIndexOf("."));
     }
     @Test
     public void test12(){
        String str = "123456789";
        boolean flag = str.matches("[1-9][0-9]{8}+");//第一个数字不为0，后面刚好8个数字
        System.out.println(flag);
     }
     @Test
     public void test13(){
        String str = "张三是傻逼";
        String str1 = str.replace("傻逼","xxx");
        System.out.println(str1);
     }
     @Test
    public void test14(){
        String str = "sadsa165a6f.fa5614g";
        String str1 = str.replaceAll("[^a-zA-z]","x");
         System.out.println(str1);
     }
     @Test
    public void test15(){
        String str = "hello java hello world";
        String str2 = "1hello2java3hello4world";
        String[] str1 = str.split(" ");
         for (int i = 0; i < str1.length; i++) {
             System.out.println(str1[i]);
         }
     }
     @Test
     public void test16(){
        String stu_string = "张三.23|李四.24|王五.25";
        String[] strings = stu_string.split("\\|");
        Students[] stu = new Students[strings.length];

         for (int i = 0; i < strings.length; i++) {
             String[] strings1 = strings[i].split("\\.");
             stu[i] = new Students(strings1[0],Integer.parseInt(strings1[1]));
             System.out.println(stu[i]);
         }
     }
    @Test
    public void test17(){
        StringBuilder str = new StringBuilder("hello");
        str.append("java").append(true).append(5);
        System.out.println(str);
    }
    public void test18(){

    }
}
class Students{
    private String name;
    private int age;
    public Students(){

    }
    public Students(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(){
        this.name = name;
    }
    public void setAge(){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}