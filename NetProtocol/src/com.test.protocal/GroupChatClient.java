package com.test.protocal;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GroupChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.50.8",9999);
        SendThread st = new SendThread(socket);
        ReceiveThread rt = new ReceiveThread(socket);
        st.start();
        rt.start();
        //等待发送线程停下来，再往下走
        try {
            st.join();
        } catch (InterruptedException e) {
             throw new RuntimeException(e);
        }
        //让接收数据的线程停下
        rt.setFlag(false);
        //等接收线程停下，再往下走，断开连接
        try {
            rt.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        socket.close();
    }
}
class SendThread extends Thread{
    private Socket socket;
    public SendThread(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try {
            Scanner scanner = new Scanner((System.in));
            OutputStream out = socket.getOutputStream();
            PrintStream ps = new PrintStream(out);
            while (true){
                System.out.println("请输入：");
                String content = scanner.nextLine();
                //给服务器发送
                ps.println(content);
                if("bye".equals(content)){

                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
class ReceiveThread extends Thread{
    private Socket socket;
    private boolean flag = true;
    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while(flag){
                String message = br.readLine();
                System.out.println(message);
                if("bye".equals(message)){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}