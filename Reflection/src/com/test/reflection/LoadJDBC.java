package com.test.reflection;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.ClassLoader;
import java.util.Properties;

public class LoadJDBC {
    @Test
    public void test() throws IOException {
        //这里开发环境是src，生产环境可能是bin，web下面又不同
//        FileReader fr = new FileReader("src/jdbc.properties");
        FileReader fr = new FileReader("src/jdbc.properties");
        BufferedReader br  = new BufferedReader(fr);
        String line  = br.readLine();
        System.out.println(line);
        br.close();
        fr.close();
    }    @Test
    public void test2() throws IOException {
        Properties pro =  new Properties();//集合、map、键值对
        Class clazz = LoadJDBC.class;
        ClassLoader loader = clazz.getClassLoader();
        InputStream in = loader.getResourceAsStream("jdbc.properties");
        pro.load(in);
        System.out.println(pro);
        System.out.println(pro.getProperty("\"username\""));
    }
    @Test
    public void test3() throws IOException {
        Properties pro =  new Properties();//集合、map、键值对
        Class clazz = LoadJDBC.class;
        ClassLoader loader = clazz.getClassLoader();
        InputStream in = loader.getResourceAsStream("com/test/reflection/data.properties");
        pro.load(in);
        System.out.println(pro);
        System.out.println(pro.getProperty("username"));
    }
    @Test
    public void test4() throws IOException{
        //使用new FileInputStream
        Properties pro = new Properties();
        pro.load(new FileInputStream("data.properties"));
        System.out.println(pro);
        System.out.println(pro.getProperty("username"));
    }

}
