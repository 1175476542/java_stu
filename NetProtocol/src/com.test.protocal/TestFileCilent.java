package com.test.protocal;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 * 客户端
 * 1. 从键盘输入文件路径，选择要发送的文件
 * 2. 给服务器“文件名.后缀名”
 * 3. 发送文件内容
 * 4. 接收服务器的反馈结果
 *
 * */
public class TestFileCilent {
    public static void main(String[] args) throws IOException {
        //1. 连接服务器
        Socket socket = new Socket("192.168.50.8",9999);
        //输入文件路径
        Scanner scanner =  new Scanner(System.in);
        System.out.println("请选择文件：");
        //接收文件路径
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        //把文件输出到服务器
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF(file.getName());
        //把文件内容发送到服务器
        int len;
        byte[] b = new byte[1024];
        FileInputStream fis  = new FileInputStream(file);
        while ((len = fis.read(b))!=-1){
            dos.write(b,0,len);
        }
        socket.shutdownOutput();
        //接受反馈
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br  = new BufferedReader(isr);
        String result = br.readLine();
        System.out.println(result);
        socket.close();
        fis.close();
    }
}
