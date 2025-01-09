package com.test.protocal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestFileServer {
    public static void main(String[] args) throws IOException {
        /*
        * 从客户端发送文件到服务端
        * 1. 接收客户端连接
        * 2. 接收文件名后缀名
        * 在当前项目找位置存储，这里新建upload.dat
        * 如何解决文件重名问题    文件名需要处理
        *   可以加入时间戳或者其他唯一编码的UUID等值
        *   .后缀名需要保留，他代表文件类型
        * 3.接收文件内容
        * 这里既有要接受的文件名，又有要接受的文件内容，只能选择字节流
        * 可以同时处理字符串和字节类型数据的有：
        * DataInputStream
        * ObjectInputStream，但是当前项目  麻烦
        * */
        ServerSocket server = new ServerSocket(9999);

        Socket socket = server.accept();
        //接收文件名
        InputStream is = socket.getInputStream();
        DataInputStream dis  = new DataInputStream(is);
        //读取文件名
        String fileName = dis.readUTF();
        //获取时间戳
        long current = System.currentTimeMillis();
        //获取后缀名.的下标
        int index = fileName.lastIndexOf(".");
        //后缀名
        String ext = fileName.substring(index);
        //文件名
        fileName = fileName.substring(0,index);
        //新文件名
        String newFileName = "javase_code/NetProtocol/upload/"+fileName + "-" + current + ext;
        //创建文件输出流，写入新文件
        FileOutputStream fos  =  new FileOutputStream(newFileName);
        //接收文件内容
        int len;
        byte[] b = new byte[1024];
        while ((len = dis.read(b))!= -1){
            fos.write(b,0,len);
        }
        //反馈客户端，接收完毕
        OutputStream out  =  socket.getOutputStream();
        PrintStream ps = new PrintStream(out);
        ps.println("上传完毕");

        //断开连接
        fos.close();
        socket.close();
        server.close();
    }
}
