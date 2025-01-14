package com.test.protocal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveWithUDP {
    public static void main(String[] args) throws IOException {
        //接收方也要socket
        //接收方的端口号，制定，IP自动获取
        DatagramSocket ds = new DatagramSocket(9999);
        //准备数据报
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        //接收数据
        ds.receive(dp);
        //拆解数据
        byte[] data = dp.getData();//接受的数据
        int len  = dp.getLength();//接受的实际长度
        System.out.println(new String(data,0,len));
        //关闭
        ds.close();

    }
}
