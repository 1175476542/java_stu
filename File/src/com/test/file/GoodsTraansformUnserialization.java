package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.*;

public class GoodsTraansformUnserialization {
    @Test
    public void test1() throws IOException {
        FileOutputStream fos = new FileOutputStream("goods.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Goods goods = new Goods("4070super",8,5400);
        oos.writeObject(goods);
        oos.close();
        fos.close();
    }
    @Test
    public void test2() throws IOException,ClassNotFoundException {
        FileInputStream fis = new FileInputStream("goods.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
        fis.close();

    }
}
