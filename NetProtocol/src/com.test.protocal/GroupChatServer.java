package com.test.protocal;

import Test_Array.ArrayLetters;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupChatServer {
    private static ArrayList<Socket> online = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            //接收客户端连接
            Socket socket = server.accept();
            //添加在线进集合
            online.add(socket);
            //服务器进程
            GroupThread gt = new GroupThread(socket);
            gt.start();
        }

    }

    //使用内部类的原因是为了用上面的online集合
    private static class GroupThread extends Thread {
        private Socket socket;
        private String ip;
        public GroupThread(Socket socket) {
            this.socket = socket;
            this.ip = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            try {
                sendTOOthers(ip+"上线了");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //接收当前的客户端发送消息
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                String content;
                while ((content = br.readLine()) != null) {
                    sendTOOthers(ip+ "说："+content);
                    if ("bye".equals(content)) {
                        OutputStream os  = socket.getOutputStream();
                        PrintStream ps1 = new PrintStream(os);
                        ps1.println("bye");
                        break;
                    }

                }
                sendTOOthers(ip+"下线了");
            } catch (IOException e) {
                try {
                    sendTOOthers(ip+"掉线了");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            //给其他在线客户端转发
        }
        public void sendTOOthers(String str) throws IOException {
            //遍历所有的online的客户端
            Iterator<Socket> iterator = online.iterator();
            while(iterator.hasNext()){
                Socket socket = iterator.next();
                if(!socket.equals(this.socket)){
                    try {
                        OutputStream os = socket.getOutputStream();
                        PrintStream ps = new PrintStream(os);
                        ps.println(str);
                    } catch (IOException e) {
                        iterator.remove();
                    }
                }

            }
        }
    }

}
