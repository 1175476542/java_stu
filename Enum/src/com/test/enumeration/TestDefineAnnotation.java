package com.test.enumeration;

import java.lang.annotation.Inherited;

public class TestDefineAnnotation {
    public static void main(String[] args) {

    }
}
//使用注解
@MyAnnotation
class MyClass{

}

class Sub extends MyClass{

}
//自定义注解

//表示这个自定义注解可以被继承
@Inherited
@interface MyAnnotation{

}