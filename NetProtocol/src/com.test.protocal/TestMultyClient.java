package com.test.protocal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TestMultyClient {
    //多个客户端发送
    public static void main(String[] args) throws IOException {
        Socket socket  = new Socket("192.168.217.8",9999);
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
            System.out.println("请输入词语：");
            String word = sc.next();
            ps.println(word);
            if("bye".equals(word)){
                break;
            }
            String result  =br.readLine();
            System.out.println("服务器返回："+result);
        }
        sc.close();
        socket.close();
    }
}
