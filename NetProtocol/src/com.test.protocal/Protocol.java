package com.test.protocal;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Protocol {
    @Test
    public void test() throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local);
    }
    @Test
    public void test2() throws  UnknownHostException{
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
    }
    @Test
    public void test3()throws UnknownHostException{
        byte[] addr = {(byte)192,(byte)168,2,103};
        InetAddress local = InetAddress.getByAddress(addr);
        System.out.println(local);
    }

}
