package com.test.reflection;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.ClassLoader;
import java.lang.annotation.ElementType;

public class ClassObject {
    @Test
    public void test1() {
        Class c1 = int.class;//基本数据类型
        Class c2 = void.class;//特殊的空类型
        Class c3 = String.class;//系统定义的类类型
        Class c7 = ClassObject.class;//自定义的类类型
        Class c8 = Serializable.class;//接口类型
        Class c4 = ElementType.class;//枚举类型
        Class c5 = Override.class;//注解类型
        Class c6 = int[].class;//数组类型
//        System.out.println(c1);
    }
    @Test
    public void test2(){
        Class c1 = "".getClass();
    }
    @Test
    public void test3() throws ClassNotFoundException {
        Class c1 = String.class;
        Class c2 = "".getClass();
        Class c3 = Class.forName("java.lang.String");
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }
    @Test
    public void test4() throws ClassNotFoundException {
        Class c1 = ClassObject.class;
        ClassLoader cl = c1.getClassLoader();
        Class c2 = cl.loadClass("com.test.reflection.TestClass");
        Class c3 = TestClass.class;
        System.out.println(c3 == c2);
    }
}
