package com.test.protocal;

import org.junit.jupiter.api.condition.OS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {
        //打开服务器
        ServerSocket server  = new ServerSocket(9999);
        //打开信道，等待连接
        Socket socket = server.accept();
        System.out.println("客户端连接成功");
        InputStream is = socket.getInputStream();
        byte[] c = new byte[1024];
        int len;
        System.out.println("服务器收到的信息：");
        while ((len = is.read(c))!=-1){
            System.out.println(new String(c,0,len));
        }
        //获取输出流
        OutputStream os = socket.getOutputStream();
        //发送数据
        os.write("欢迎登录".getBytes());
        //关闭信道
        socket.close();
        //关闭服务器
        server.close();
    }
}
