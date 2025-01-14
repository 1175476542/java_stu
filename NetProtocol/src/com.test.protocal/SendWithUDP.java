package com.test.protocal;

import java.io.IOException;
import java.net.*;

public class SendWithUDP {
    public static void main(String[] args) throws IOException {
        //发送方，建立一个Socket
        //发送方的端口号和IP地址，自动获取
        DatagramSocket ds = new DatagramSocket();
        String str = "Hello World";
        byte[] b = str.getBytes();
        InetAddress ip = InetAddress.getByName("192.168.2.105");
        DatagramPacket dp = new DatagramPacket(b,0,b.length,ip,9999);
        ds.send(dp);
        System.out.println("发送完毕");
        ds.close();
    }
}
