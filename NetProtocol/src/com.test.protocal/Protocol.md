# 网络协议
## 网络协议概述
1. 网路通信三要素
- 地址：IP地址，定位到一台设备
- 端口号：定位到一个应用程序（进程）
- 网络协议：对速率、传输代码、代码结构、传输控制步骤、出错控制步骤等制定标准
  - 通俗的监管：保证如何准确的到达对方那里，能够正确的解析出数据来
2. OSI（Open System Interconnection）开放系统互连参考模型。
- 它把计算机网络分成物理层、数据链路层、网络层、传输层、会话层、表示层、应用层等七层。
物理层：建立、维护、断开物理连接
- 数据链路层：建立逻辑连接、进行硬件地址寻址、差错校验等功能。将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正。
- 网络层：进行逻辑地址寻址，实现不同网络之间的路径选择。协议有：ICMP、IGMP、IP（IPV4 IPV6）、ARP、RARP。
- 传输层：定义传输数据的协议端口号，以及流控和差错校验。协议有：TCP、UDP。
- 会话层：建立、管理、终止会话。对应主机进程，指本地主机与远程主机正在进行的会话
- 表示层：数据的表示、安全、压缩。格式有：JPEG、ASCll、DECOIC、加密格式等
- 应用层：网络服务与最终用户的一个接口。协议有：HTTP、FTP、SMTP、DNS、TELNET、HTTPS、POP3等等。

3. 最早确定的，也是最重要的是TCP/IP协议。把这些协议家族称为TCP/IP协议簇。
- 主机-网路层：硬件层面
- 网络层：例如IP寻址
- 传输层：协议有：TCP、UDP。
- 应用层：程序员面对的
4. TCP/UDP
- TCP：(Transmission Control Protocol，传输控制协议)面向连接的，可靠的，基于字节流的，适用于大数据量的传输的协议。
- UDP：(User Datagram Protocol，用户数据报协议)非面向连接，不可靠的，基于用户数据报（报文），只能支持最多64k以内的数据的发送。
![TCP三次握手四次挥手.png](TCP%E4%B8%89%E6%AC%A1%E6%8F%A1%E6%89%8B%E5%9B%9B%E6%AC%A1%E6%8C%A5%E6%89%8B.png)
## IP地址
1. IPV4:32位，4个整数，每一个整数是一个字节（例如：192.168.1.1），每个整数范围是：0-255
2. IPV6：128位，8个16进制值来表示（例如：1080:0:0:0:8:800:200C:417A）
3. 特殊的IP地址：
- 127.0.0.1：本地的回传地址
- 224.0.0.0至239.255.255.255：广播IP地址
4. 域名：用人比较方便记忆和识别的单词来代表IP地址
- 例如：www.baidu.com
- 域名->域名解析器->IP地址
5. 域名后缀含义：
- 一级域名：
  - .com：商业
  - .cn：中国
  - .org：非营利性组织
  - .gov：政府
  - .edu：教育
## 端口号
1. [0,65535]之间无符号，2个字节
2. 公认端口（Well-Known Ports）：范围从0-1023
- 例如：http(80),ftp(21),SMTP(25)
3. 注册端口（Register Ports）：端口号从1024-49151
- 例如：Tomcat(8080),JBOSS(8080),Oracle(1521),MySQL(3306),SQL Server(1433),QQ(1080)
4. 动态、私有端口（Dynamic and/Private Ports）：范围从49152-65535，这些端口号一般不固定奉陪给某个服务
## InetAddress 
- 用来包装IP地址对象的
1. InetAddress有两个子类，Inet4Address、Inet6Address
2. API
- InetAddress.getByName:域名得到IP
```java
 public void test() throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local);
    }
```
- InetAddress.getLocalHost：本地IP
```java
 public void test2() throws  UnknownHostException{
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
    }
```
- InetAddress.getByAddress:靠IP地址找，IP地址是byte的数组
```java
    public void test3()throws UnknownHostException{
        byte[] addr = {(byte)192,(byte)168,2,103};
        InetAddress local = InetAddress.getByAddress(addr);
        System.out.println(local);
    }
```
> 运行结果：/192.168.2.103
3. 如果后面的API中，要接受的IP的形参是InetAddress的话，就可以刚才的方法来创建对象
## 传输协议
- 不管传输层使用的是TCP/UDP协议，java中用这样的API来表示：Socket（套接字）
1. 分类
- 流套接字：用于TCP，ServerSocket和类的Socket
- 数据报套接字：用于UDP，DatagramSocket
- Socket也叫套接字，是两台机器间通信的端点。可以和网卡驱动进行交流，
负责把数据交给网卡驱动，或者从网卡驱动提取数据
## 服务器和客户端的单词传输
- 可以理解为socket的输入输出流
```java
//客户端
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

```

```java
//服务器端
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

```
## 多次通信单词反转
1. 接受客户端的连接
2. 接受客户端的词语
3. 词语反转发送给客户端
4. 执行2、3多次，直到客户端发送bye
```java
//Server
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

```
```java
//Client
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

```

## 文件传输
```java
//客户端
package com.test.protocal;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 * 客户端
 * 1. 从键盘输入文件路径，选择要发送的文件
 * 2. 给服务器“文件名.后缀名”
 * 3. 发送文件内容
 * 4. 接收服务器的反馈结果
 *
 * */
public class MultyFileClient {
  public static void main(String[] args) throws IOException {
    //1. 连接服务器
    Socket socket = new Socket("192.168.50.8",9999);
    //输入文件路径
    Scanner scanner =  new Scanner(System.in);
    System.out.println("请选择文件：");
    //接收文件路径
    String filePath = scanner.nextLine();
    File file = new File(filePath);
    //把文件输出到服务器
    OutputStream os = socket.getOutputStream();
    DataOutputStream dos = new DataOutputStream(os);
    dos.writeUTF(file.getName());
    //把文件内容发送到服务器
    int len;
    byte[] b = new byte[1024];
    FileInputStream fis  = new FileInputStream(file);
    while ((len = fis.read(b))!=-1){
      dos.write(b,0,len);
    }
    socket.shutdownOutput();
    //接受反馈
    InputStream is = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br  = new BufferedReader(isr);
    String result = br.readLine();
    System.out.println(result);
    socket.close();
    fis.close();
  }
}


```

```java
//服务器端
package com.test.protocal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultyFileServer {
  public static void main(String[] args) throws IOException {
    /*
     * 从客户端发送文件到服务端
     * 1. 接收客户端连接
     * 2. 接收文件名后缀名
     * 在当前项目找位置存储，这里新建upload.dat
     * 如何解决文件重名问题    文件名需要处理
     *   可以加入时间戳或者其他唯一编码的UUID等值
     *   .后缀名需要保留，他代表文件类型
     * 3.接收文件内容
     * 这里既有要接受的文件名，又有要接受的文件内容，只能选择字节流
     * 可以同时处理字符串和字节类型数据的有：
     * DataInputStream
     * ObjectInputStream，但是当前项目  麻烦
     * */
    ServerSocket server = new ServerSocket(9999);
    while(true){
      Socket socket = server.accept();
      MultyFileServerThread t  = new MultyFileServerThread(socket);
      t.start();
    }
  }
}
class MultyFileServerThread extends Thread {
  private Socket socket;

  public MultyFileServerThread(Socket socket) throws IOException {
    this.socket = socket;
  }
  public void run() {
    FileOutputStream fos  = null;
    try {
      //接收文件名
      InputStream is = socket.getInputStream();
      DataInputStream dis  = new DataInputStream(is);
      //读取文件名
      String fileName = dis.readUTF();
      //获取时间戳
      long current = System.currentTimeMillis();
      //获取后缀名.的下标
      int index = fileName.lastIndexOf(".");
      //后缀名
      String ext = fileName.substring(index);
      //文件名
      fileName = fileName.substring(0,index);
      //新文件名
      String newFileName = "javase_code/NetProtocol/upload/"+fileName + "-" + current + ext;
      //创建文件输出流，写入新文件
      fos = new FileOutputStream(newFileName);
      //接收文件内容
      int len;
      byte[] b = new byte[1024];
      while ((len = dis.read(b))!= -1){
        fos.write(b,0,len);
      }
      //反馈客户端，接收完毕
      OutputStream out  =  socket.getOutputStream();
      PrintStream ps = new PrintStream(out);
      ps.println("上传完毕");
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      //断开连接
      try {
        fos.close();
        socket.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }


  }

}

```

## 聊天室案例
```java
//客户端
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
```
```java
//服务器端
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

```