package com.test.protocal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.217.8",9999);
        OutputStream os = socket.getOutputStream();
        os.write(("你好".getBytes()));
        socket.shutdownOutput();
        System.out.println("客户端收到的信息：");
        InputStream is = socket.getInputStream();
        byte[] data = new byte[1024];
        int len;
        while ((len = is.read(data))!=-1){
            System.out.println(new String(data,0,len));
        }
    }
}
