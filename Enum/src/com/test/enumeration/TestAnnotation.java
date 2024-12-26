package com.test.enumeration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class TestAnnotation {
    public static void main(String[] args) {

    }
}
@Target(ElementType.TYPE)
@interface MyAnnotation2{

}
@MyAnnotation
class Annotation{

}
@interface ParamAnnotation{
//    String name();
//    String value();//使用value时，在使用时可以不加参数名称
    String value() default "cxy";//表示注解配置参数的默认值
}
@ParamAnnotation()//有参数的注解使用时要带参数，是要读取注解的程序使用的
class ParamClass{

}
