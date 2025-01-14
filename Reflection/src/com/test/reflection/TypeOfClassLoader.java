package com.test.reflection;

import org.junit.jupiter.api.Test;

import java.lang.ClassLoader;

public class TypeOfClassLoader {
    public static void main(String[] args) {

    }
}
class Test1{
    @Test
    public void test(){
        Class clazz = Test1.class;
        ClassLoader cl = clazz.getClassLoader();
        System.out.println(cl);//不是null，就不是引导类加载器
    }
    @Test
    public void test2(){
        Class clazz = String.class;
        ClassLoader cl = clazz.getClassLoader();
        System.out.println(cl);//这里是null，所以String的加载器是引导类加载器
    }
}