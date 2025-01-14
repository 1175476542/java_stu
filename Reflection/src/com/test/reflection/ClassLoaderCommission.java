package com.test.reflection;

import org.junit.jupiter.api.Test;

import java.lang.ClassLoader;

public class ClassLoaderCommission {
    //类加载器的双亲委托模式

}
class Test2{
    @Test
    public void test1(){
        Class clazz = Test2.class;
        ClassLoader cl = clazz.getClassLoader();
        System.out.println(cl);
        ClassLoader parent = cl.getParent();
        System.out.println(parent);
    }
    @Test
    public void test2(){

    }
}