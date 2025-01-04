package com.test.file;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestStream {
    public static void main(String[] args) {

    }
}

class TestStream1 {
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("./test2.txt");
        byte[] b = new byte[10];
        int len;
        while ((len = fis.read(b)) != -1) {
            System.out.printf(new String(b, 0, len));//可能乱码，因为制定了数组长度，可能会分割字节
//            System.out.printf(Arrays.toString(b));
        }
        fis.close();
    }
    @Test
    public void test2() throws IOException {
        //任意类型的文件，只能选择字节流
        //不会乱码，因为全部复制完了才显示
        copy("javase_code/File/src/com/test/file/1.JPG","javase_code/File/src/com/test/file/2.JPG");
    }
    public void copy(String src,String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] b = new byte[10];
        int len;
        //src-->fis-->byte[]-->fos--->dest
        while ((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fis.close();
        fos.close();
    }
    @Test
    public void test3BufferIO() throws IOException {
        //用它来读取一个文件
        FileReader fr = new FileReader("javase_code/File/src/com/test/file/test1.txt");
        BufferedReader br = new BufferedReader(fr);
        String str;
        while((str = br.readLine())!= null){
            System.out.printf(str);
        }
        fr.close();
        br.close();
    }
    @Test
    public void test4BufferCopyFile() throws IOException {
        //缓冲比正常的复制文件更快
        long start = System.currentTimeMillis();
        FileReader fr = new FileReader("javase_code/File/src/com/test/file/test1.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("javase_code/File/src/com/test/file/test3.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String str;
        int len;
        while((str = br.readLine())!=null){
            bw.write(str);
        }
        br.close();
        fr.close();
        bw.close();
        br.close();
        long end = System.currentTimeMillis();
        System.out.printf("总耗时："+(end-start)+"ms");
    }
    @Test
    public void test5BufferedStream() throws IOException {
        //任意类型的文件，只能选择字节流
        //不会乱码，因为全部复制完了才显示
        copy1("javase_code/File/src/com/test/file/1.JPG","javase_code/File/src/com/test/file/2.JPG");
    }
    public void copy1(String src,String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = new byte[10];
        int len;
        //src-->fis-->byte[]-->fos--->dest
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        bis.close();//必须按照顺序
        fis.close();
        bos.close();
        fos.close();
    }
    @Test
    public void test6Transform() throws IOException {
        FileReader fr = new FileReader("E:/java/IO.txt");
        char[] c = new char[10];
        int len = fr.read(c);
        System.out.println(new String(c,0,len));
        fr.close();//不行，乱码
    }
    @Test
    public void test7InputStreamReader() throws IOException {
        FileInputStream fis = new FileInputStream("E:/java/IO.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gb2312");
        char[] c = new char[10];
        int len =  isr.read(c);

        System.out.println(new String(c,0,len));
        isr.close();
        fis.close();
    }
    @Test
    public void tset8OutputStreamWriter() throws IOException{
        String str = "王五、赵六";
//        FileWriter fw = new FileWriter("E:/java/IO.txt");
        FileOutputStream fos = new FileOutputStream("E:/java/IO.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gb2312");
        osw.write(str);
        osw.close();
        fos.close();
        FileInputStream fis = new FileInputStream("E:/java/IO.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gb2312");
        char[] c = new char[10];
        int len = isr.read(c);
        System.out.printf(new String(c,0,len));
        fis.close();
        isr.close();
    }
    @Test
    public void testDataIO () throws IOException{
        int a = 1;
        String  s = "君子不立危墙";
        boolean b = true;
        double d = 1.1;
        char c = '学';
        FileOutputStream fos = new FileOutputStream("data.dat");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(a);
        dos.writeUTF(s);
        dos.writeBoolean(b);
        dos.writeDouble(d);
        dos.writeChar(c);
        dos.close();
        fos.close();
    }
    @Test
    public void testDataRead() throws IOException{
        FileInputStream fis = new FileInputStream("data.dat");
        DataInputStream dis = new DataInputStream(fis);
        int a = dis.readInt();
        String s = dis.readUTF();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();
        char c = dis.readChar();
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
        System.out.println(b);
        System.out.println(s);
        dis.close();
        fis.close();
        //读写顺序必须一致
    }
}
