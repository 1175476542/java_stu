package com.test.enumeration;


import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Target;
import static java.lang.Math.*;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

public class TestStaticImport {
    public static void main(String[] args) {
//        System.out.println(Math.PI);
//        System.out.println(Math.sqrt(4));
        //静态导入之后就可以不用“类名.”
        System.out.println(PI);
        System.out.println(sqrt(4));

    }
}
@Target({TYPE,METHOD,FIELD})
@interface MyAnnotation1{

}