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
    @Test
    public void testGood() throws IOException,ClassNotFoundException{
        FileInputStream fis = new FileInputStream("good.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
        fis.close();//Good实现了Externalizable接口，可以自己定制输入输出

    }
    @Test
    public void testGoodOut()throws IOException,ClassNotFoundException{
        Good g = new Good("3090TI",8,3000);
        g.setBrand("七彩虹");
        FileOutputStream fos = new FileOutputStream("good.dat");
        ObjectOutputStream oos  =new ObjectOutputStream(fos);
        oos.writeObject(g);
        oos.close();
        fos.close();
    }
}
