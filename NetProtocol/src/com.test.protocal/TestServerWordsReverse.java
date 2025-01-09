package com.test.protocal;

import org.junit.jupiter.api.condition.OS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerWordsReverse {
    public static void main(String[] args) throws IOException {
        //1.开启服务器
        ServerSocket server  = new ServerSocket(9999);
        //2. 接受一个服务器连接
        Socket socket  = server.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        String word;
        while ((word = br.readLine())!=null){
            if("bye".equals(word)){
                break;
            }else {
                StringBuilder sb = new StringBuilder(word);

                word  = sb.reverse().toString();
                ps.println(word);
            }
        }
        socket.close();
        server.close();
    }
}
