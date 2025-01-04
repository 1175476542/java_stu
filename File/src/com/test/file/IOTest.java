package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {

    }
}

class Test3 {
    @Test
    public void test1() throws IOException {
        //读取一个纯文本文件
        //因为是纯文本文件，选择字符流
        //因为是读取操作，所以选择字符输入流FIleReader
        FileReader read = new FileReader("src/com/test/file/test1.txt");//返回一个int类型的返回值
        int data = read.read();
        System.out.println("data = " + data);//
        read.close();
    }

    @Test
    public void test2() throws IOException {
        //读取一个纯文本文件
        //因为是纯文本文件，选择字符流
        //因为是读取操作，所以选择字符输入流FIleReader
        FileReader read = new FileReader("src/com/test/file/test1.txt");//返回一个int类型的返回值
        char[] c = new char[10];

        while (true) {
            int len = read.read(c);
            System.out.println(len);//返回读取到的字符个数，运行结果17
            if (len == -1) {
                break;
            }
            System.out.println(new String(c, 0, len));
        }
        read.close();
    }
    @Test
    public void test3() throws IOException {
        //写一些数据到test1.txt
        String path = "javase_code/File/src/com/test/file/test1.txt";

        Scanner input = new Scanner(System.in);
        System.out.println("请输入一段字符：");
        String s = input.nextLine();
        FileWriter fw = new FileWriter(path,true);//true是代表直接在后面加
        fw.write(s);
        fw.close();
        input.close();
    }
    @Test
    public void test4() throws IOException {
        copy("test1.txt","test2.txt");
    }
    public void copy(String src,String dest) throws IOException {
        String path = "javase_code/File/src/com/test/file/test1.txt";
        String path1 = "./test2.txt";
        FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter(path1);
        char[] c = new char[10];
        int len;
        while ((len=fr.read(c))!=-1){
            fw.write(c,0,len);
        }
        fr.close();
        fw.close();
    }

}