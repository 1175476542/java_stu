package com.test.enumeration;

public class TestEnum {
    public static void main(String[] args) {
        Gender g1 = Gender.MALE;
        Gender g2 = Gender.MALE;//两者地址相同
        System.out.println(g1 == g2);
    }
}

class Gender{
    //public：使得外面可以直接访问
    //static：使得可以使用“类名.”访问
    //final：强调这个对象吧是不可变的
    public static final Gender MALE = new Gender("男");//内部定义
    public static final Gender FEMALE = new Gender("女");//内部定义
    private String description;
    private Gender(String description){//构造器使用private是因为不随意让外部定义、使用
        this.description = description;
    }
}