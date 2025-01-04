package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.*;

public class SerializationTest {
    //序列化和反序列化
}
class TestSerialization{
    @Test
    public void test1() throws IOException {
        User user = new User("cxy","123",18);
        FileOutputStream fos = new FileOutputStream("obj.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
        fos.close();
    }
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("obj.dat");
        ObjectInputStream ois =new ObjectInputStream(fis);
        Object obj = ois.readObject();//可能会存在没有这个类(User)
        System.out.println(obj);
        ois.close();
        fis.close();
    }
}