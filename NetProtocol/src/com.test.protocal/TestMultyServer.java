package com.test.protocal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestMultyServer {
    //多个客户端发送
    public static void main(String[] args) throws IOException {
        //1.开启服务器
        ServerSocket server  = new ServerSocket(9999);
        boolean flag = true;
        while(flag){
            //2. 接受一个服务器连接
            Socket socket  = server.accept();
            ServerThread thread  = new ServerThread(socket);
            thread.start();
        }

        server.close();
    }
}
class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
