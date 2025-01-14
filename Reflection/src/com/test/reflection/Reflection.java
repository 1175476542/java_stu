package com.test.reflection;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class Reflection{
    private Class clazz;

    @Before
    public void test01()throws Exception{
        //如果这个类名是在配置文件中，先获取类名
        Properties pro = new Properties();
        pro.load(Reflection.class.getClassLoader().getResourceAsStream("bean.properties"));
        String className = pro.getProperty("className");//key就是bean.properties文件中=左边的属性名

        //（1）获取这个类的Class对象
        clazz = Class.forName(className);
        System.out.println(clazz);
    }
    @Test
    public void test() throws ClassNotFoundException, IOException {
        //（2）获取类的详细信息
        //clazz代表com.test.ext.demo.testDemo这个类

        //获取包名
        Package pkg = clazz.getPackage();
        System.out.println("包名：" + pkg.getName());

        //获取类名
        System.out.println("类名：" + clazz.getName());

        //类的修饰符
        int mod = clazz.getModifiers();
        System.out.println("修饰符的值：" + mod);
        System.out.println("修饰符：" + Modifier.toString(mod));

        Class sc = clazz.getSuperclass();
        System.out.println("父类的名称：" + sc.getName());

        Class[] interfaces = clazz.getInterfaces();
        System.out.println("父接口们：");
        for (Class inter : interfaces) {
            System.out.println(inter.getName());
        }

        //每一个属性就是一个Field的对象
        /*
         * (1)Field[] getFields() 得到所有公共的属性
         * (2)Field[] getDeclaredFields() 得到所有声明的属性
         */
        Field[] fields = clazz.getDeclaredFields();
        int count = 0;
        for (Field field : fields) {
            count++;
            int fMod = field.getModifiers();
            System.out.println(count + "：属性的修饰符：" + Modifier.toString(fMod));

            System.out.println(count + "：属性的数据类型：" + field.getType().getName());

            System.out.println(count + "：属性的名称：" + field.getName());
        }

        /*
         * Constructor[]  getConstructors()：得到所有的公共的构造器
         * Constructor[]  getDeclaredConstructors()()：得到所有的声明的构造器
         */
        count = 0;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            count++;
            int cMod = constructor.getModifiers();
            System.out.println(count + "：构造器的修饰符：" + Modifier.toString(cMod));
            System.out.println(count + "：构造器的名称：" + constructor.getName());
            Class[] parameterTypes = constructor.getParameterTypes();
            System.out.println(count + "：构造器的形参列表：" + Arrays.toString(parameterTypes));
        }

        /* (1)Method[] getMethods(); 得到所有公共的方法
         * (2)Method[] getDeclaredMethods(); 得到所有声明的方法
         */
        count=0;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            count++;
            int mMod = method.getModifiers();
            System.out.println(count + "：方法的修饰符：" + Modifier.toString(mMod));
            System.out.println(count +"：方法的返回值类型：" + method.getReturnType());
            System.out.println(count + "：方法的名称：" + method.getName());
            System.out.print(count + "：抛出的异常类型们：");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            System.out.println(Arrays.toString(exceptionTypes));
            Class[] parameterTypes = method.getParameterTypes();
            System.out.println(count + "：方法的形参列表：" + Arrays.toString(parameterTypes));
        }
    }
    @Test
    public void test2(){
        int mod = String.class.getModifiers();
        System.out.println("修饰符的值：" + mod);
        System.out.println("修饰符：" + Modifier.toString(mod));
    }
}
