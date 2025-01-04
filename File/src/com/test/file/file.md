# 文件

- java.io.file:类
- 文件和目录 路径名的抽象表示形式
- 通俗的讲File类的对象代表一个文件或一个目录（文件夹）

## 路径的分隔符

- windows：\或/
- 其他平台：/
- 或者file.seqarator

```java
    public void test1(){
        File file1=new File("C:\\windows\\appData");
        File file2=new File("C:/windows/appData");
        File file3=new File("C:"+File.separator+"windows"+File.separator+"appData");
        }
```

## API

1. 获取文件详细信息

- getName():文件名
- length():文件大小，只能直接返回文件的大小，不能直接放回目录的大小，文件夹的大小是文件夹里面所有的文件大小的累加和
- exists():文件是否存在
- getParent():文件的父文件
- canRead():文件是否可读
- canWrite():文件是否可写
- isHidden():文件是否是隐藏文件

```java
    @Test
public void test1(){
        File file1=new File("C:\\windows\\appData");
        File file2=new File("C:/windows/appData");
        File file3=new File("C:"+File.separator+"windows"+File.separator+"appData");
        //新建目录对象
        File dir=new File("{path}");
        }
@Test
public void test2(){
        //API
        File dir=new File("{path}");
        System.out.println("文件名："+dir.getName());
        System.out.println("文件大小："+dir.length());
        System.out.println("文件是否存在："+dir.exists());
        System.out.println("文件的父文件："+dir.getParent());
        System.out.println("文件是否可读："+dir.canRead());
        System.out.println("文件是否可写："+dir.canWrite());
        System.out.println("文件是否是隐藏文件："+dir.isHidden());
        //返回父文件名称
        String parent=dir.getParent();
        //返回父文件对象
        File file=dir.getParentFile();
        System.out.println("文件的父目录："+parent);

        System.out.println("文件修改时间："+dir.lastModified()+"毫秒");
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("文件上次修改时间为："+sf.format(new Date(dir.lastModified())));
        }
```

2. 获取文件路径

- getPath():获取相对路径
- getAbsolutePath():获取绝对路径
- getCanonicalPath():获取规范路径

```java
    public void test3()throws IOException{
        //路径
        File file=new File("/file.md");//相对路径
        System.out.println("文件的路径："+file.getPath());
        System.out.println("文件的绝对路径："+file.getAbsolutePath());
        System.out.println("文件的规范路径："+file.getCanonicalPath());
        }
```

3. 创建、删除、重命名

- createNewFile()：只能创建文件
- mkdir()：创建文件夹,只能创建一级目录
- mkdirs()：创建多级目录文件夹

```java
    public void test4()throws IOException{
        //创建
        File file=new File("./test.txt");
        File file1=new File("./test");
        File file2=new File("./test1/test/test");
        if(!file.exists()){
        System.out.println("创建文件");
        file.createNewFile();
        }
        if(!file1.exists()){
        file1.mkdir();
        }
        if(!file2.exists()){
        file2.mkdirs();
        }
        }
```

- delete()：删除文件和空文件夹、空目录

```java
    public void test5(){
        //删除
        File file=new File("./test.txt");
        File file1=new File("./test");
        File file2=new File("./test1/test/test");
        file.delete();

        }
```

- renameTo(File dest)：重命名为dest,文件和目录都可以

```java
    public void test6()throws IOException{
        //重命名
        File file=new File("./test.txt");
        File dest=new File("./test1.txt ");
        file.createNewFile();
        file.renameTo(dest);

        }
```

4. 判断是文件还是目录

- isFile()：判断是否是一个文件
- isDirectory：判断是否是文件夹

```java
    public void test7(){
        //判断文件或文件夹是否存在或是否是文件、文件夹
        File file=new File("./test.txt");
        if(file.exists()){
        System.out.println("文件存在");
        }else if(file.isFile()){
        System.out.println("是一个文件");
        }else if(file.isDirectory()){
        System.out.println("是一个文件夹");
        }else{
        System.out.println("文件不存在");
        }
        }
```

5. 不存在的一个文件或者目录

- 你获取他的name，path这些都有值，因为这些属性是通过构造器创建File时指定的，而其他的属性都是默认值

## 目录的递归操作

1. 获取文件下一级

- String[] list():得到下一级文件或目录的名称

```java
    public void test8(){
        //获取文件下一级目录
        File file=new File("../file");
        String[]list=file.list();
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }
        for(Object obj:list){
        System.out.println(obj);
        }
        }
```

2. 文件递归,通过listFiles获取文件对象

- File[] listFile()：得到下一级文件或目录的File对象

```java
    public void test2(){
        //得到下一级目录对象
        File file=new File("{path}");
        listAllSub(file);
        }
public void listAllSub(File file){
        if(file.isDirectory()){
        File[]fileList=file.listFiles();
        for(File dir:fileList){
        listAllSub(dir);
//                System.out.println(dir);
        }
        }else{
        System.out.println(file);
        }
        }
```

3. 求一个目录的总大小

```java
    public void test3(){
        File file=new File({path});
        System.out.println(getLength(file));

        }
public long getLength(File file){

        if(file.isFile()){
        return file.length();
        }else{
        long sum=0;
        File[]fileList=file.listFiles();
        for(File dir:fileList){
        sum+=getLength(dir);
        }
        return sum;
        }
//        return 0;
        }
```

4. 删除一个包含子目录的文件夹

```java
    public void test4(){
        File file=new File("{path}");
        deleteAllFile(file);
        }
public void deleteAllFile(File file){
        if(file.isDirectory()){
        File[]fileList=file.listFiles();
        for(File dir:fileList){
        dir.delete();
        deleteAllFile(dir);
        }
        }else if(file.isFile()){
        file.delete();
        }
        }
```

5. 文件过滤器(listFiles(new FileFileter()))

```java
    public void test5(){
        File file=new File("F:\\笔记\\java");
        File[]listFiles=file.listFiles(new FileFilter(){
@Override
public boolean accept(File pathname){
        return pathname.getName().endsWith(".md")&&
        pathname.getName().contains("s");
        }
        });
        for(File list:listFiles){
        System.out.println(list);
        }
        }
```

## IO操作

- IO是input和output的结合，即输入和输出
- 如果对于File对象来说，输入和输出操作只能针对文件，不能针对目录
- IO操作不仅仅是针对文件，他可以从网络中输入和输出
    - 输入：
    - 输出：参照物是当前程序
    - 例如：把数据写到文件中：输出操作，把数据从程序输出到文件，从文件读取数据：输入操作

1. IO的分类：
   （1）： 方向：输入流和输出流
   （2）：操作数据的单位：

- 字节流：以字节为单位的byte
- 字符流：以字符为单位的char
    - 字符流只能用于读写纯文本数据
        - 纯文本数据：内容全是字符
        - 纯文本文件：txt、html，xml，properties
    - 字节流适用于任何类型的文件
- 如果是纯文本文件用字符流更快
  （3）：功能角色不同
- 节点流和处理流
    - 节点流：和某个节点关联，例如：文件流...
    - 处理流：在节点流的基础上，加其他的处理功能的，加装饰功能的，例如：缓冲流，序列化和反序列化等

2. IO流有四大抽象的基类/超类/父类

- InputStream：字节输入流
- OutputStream：字节输出流
- Reader：字符输入流
- Writer：字符输出流
- 例如：文件IO流
    - FIleInputStream：文件字节输入流
    - FIleOutputStream：文件字节输出流
    - FIleReader：文件字符输入流
    - FIleWriter：文件字符输出流

## 文件的IO操作

1. 读取一个纯文本文件

- 步骤：选择IO流，创建IO对象
- 读写操作
- 关闭IO流，释放资源(read.close())

2. Reader系列

- int read()：读取一个字符，如果没有数据可读，返回-1,正常返回是字符的ASCII编码值

```java
    @Test
public void test1()throws IOException{
        //读取一个纯文本文件
        //因为是纯文本文件，选择字符流
        //因为是读取操作，所以选择字符输入流FIleReader
        FileReader read=new FileReader("src/com/test/file/test1.txt");//返回一个int类型的返回值
        int data=read.read();
        System.out.println("data = "+data);//
        }
```

- int read(char[] cbuf)：读取多个字符，做多读cbuf.length个，如果没有数据可读，返回-1,实际返回本次读取的字符个数

```java
    public void test2()throws IOException{
        //读取一个纯文本文件
        //因为是纯文本文件，选择字符流
        //因为是读取操作，所以选择字符输入流FIleReader
        FileReader read=new FileReader("src/com/test/file/test1.txt");//返回一个int类型的返回值
        char[]c=new char[10];

        while(true){
        int len=read.read(c);
        System.out.println(len);//返回读取到的字符个数，运行结果17
        if(len==-1){
        break;
        }
        System.out.println(new String(c,0,len));
        }
        read.close();
        }
```

- int read(char[] cbuf,int off,int len)：读取多个字符，读取的字符放到cbuf数组中，从cbuf的[off]开始存储，最多读取len个，如果没有数据可读，返回-1

3. 文件的写入
- void write(int c):写入单个字符
- void write(char[] cbuf):把整个字符数组的内容都写进去
- void write(char[] cbuf,int off,int len):把cbuf的[off]的len个写入
- void write(String str):把str字符串的内容写进去
- void write(String str,int off,int len):把字符串从[off]开始的len个字符写出去
- void close():
- void flush():刷新
4. next和nextLine的区别
- next：遇到空白符，认为输入结束
- nextLine：遇到换行符，认为输入结束
5. 使用FileReader和FileWriter复制纯文本文件
```java
public void test4() throws IOException {
        copy("test1.txt","test2.txt");
    }
    public void copy(String src,String dest) throws IOException {
        String path = "javase_code/File/src/com/test/file/test1.txt";
        String path1 = "./test2.txt";
        FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter(path1);
        char[] c = new char[10];
        int len;
        while ((len=fr.read(c))!=-1){
            fw.write(c,0,len);
        }
        fr.close();
        fw.close();
    }
```
## 使用字节流读取纯文本文件
1. InputStream:
- int read():一次读取一个字节，返回本次读取的字节的值
- int read(byte[] b):一次读取多个字节，返回本次实际读取的字节数，读取的字节存到b数组中，从[0]开始存，一次最多存b.length个字节
- int read(byte[] b,int off,int len):一次读取多个字节，返回本次实际读取的字节数，读取的字节存到b数组中，从[off]开始存，一次最多读取len个字节
- close()
- 如果达到流末尾，返回-1
2. 步骤
- 选择IO流
- 读、写
- 关闭
3. FIleOutStream
- void write():写一个字节
- void write(byte[] b):写一个字节数组的所有
- void write(byte[] b,int off,int len):从一个字节数组的[off]开始写len个
- void close()
- void flush()
4. 字节流复制
```java
 public void test2() throws IOException {
        //任意类型的文件，只能选择字节流
        //不会乱码，因为全部复制完了才显示
        copy("javase_code/File/src/com/test/file/1.JPG","javase_code/File/src/com/test/file/2.JPG");
    }
    public void copy(String src,String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] b = new byte[10];
        int len;
        //src-->fis-->byte[]-->fos--->dest
        while ((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fis.close();
        fos.close();
    }
```
5. 缓冲IO流
- 是处理流，负责在其他IO流基础上增加缓冲功能
- BufferedReader--->Reader
- BufferedWriter--->Writer
- BufferedInputStream--->InputStream
- BufferedOutputStream--->OutputStream
- 他除了继承了Reader的那些读的方法，还增加了一个String readLine()读取一行
```java
    public void test4BufferCopyFile() throws IOException {
        //缓冲比正常的复制文件更快
        long start = System.currentTimeMillis();
        FileReader fr = new FileReader("javase_code/File/src/com/test/file/test1.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("javase_code/File/src/com/test/file/test3.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String str;
        int len;
        while((str = br.readLine())!=null){
            bw.write(str);
        }
        br.close();
        fr.close();
        bw.close();
        br.close();
        long end = System.currentTimeMillis();
        System.out.printf("总耗时："+(end-start)+"ms");
    }

```

```java
 public void test5BufferedStream() throws IOException {
        //任意类型的文件，只能选择字节流
        //不会乱码，因为全部复制完了才显示
        copy1("javase_code/File/src/com/test/file/1.JPG","javase_code/File/src/com/test/file/2.JPG");
    }
    public void copy1(String src,String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = new byte[10];
        int len;
        //src-->fis-->byte[]-->fos--->dest
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        bis.close();//必须按照顺序
        fis.close();
        bos.close();
        fos.close();
    }
```
## 转换流
- 解码：字节输入流、字符输入流的转换,同时还能制定编码方式
- InputStreamReader
```java
//输出
 public void test7InputStreamReader() throws IOException {
        FileInputStream fis = new FileInputStream("E:/java/IO.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gb2312");
        char[] c = new char[10];
        int len =  isr.read(c);

        System.out.println(new String(c,0,len));
        isr.close();
        fis.close();
    }
```
- 编码：字节输出流、字符输入流
- OutputStreamWriter
```java
  public void tset8OutputStreamWriter() throws IOException{
        String str = "王五、赵六";
//        FileWriter fw = new FileWriter("E:/java/IO.txt");
        FileOutputStream fos = new FileOutputStream("E:/java/IO.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gb2312");
        osw.write(str);
        osw.close();
        fos.close();
        FileInputStream fis = new FileInputStream("E:/java/IO.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gb2312");
        char[] c = new char[10];
        int len = isr.read(c);
        System.out.printf(new String(c,0,len));
        fis.close();
        isr.close();
    }
```
## 数据IO流
- 希望java能够输出各种数据类型的数据，读取时，还能还原各种数据的类型
- DataOutputStream在OutputStream的基础上，增加了汗多方法：writeXxx(...)
- java中的Io流的类的体系设计，隐含了一个设计模式：装饰着设计模式
- 读写顺序必须一致
```java
 public void testDataIO () throws IOException{
        int a = 1;
        String  s = "君子不立危墙";
        boolean b = true;
        double d = 1.1;
        char c = '学';
        FileOutputStream fos = new FileOutputStream("data.dat");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(a);
        dos.writeUTF(s);
        dos.writeBoolean(b);
        dos.writeDouble(d);
        dos.writeChar(c);
        dos.close();
        fos.close();
    }
    @Test
    public void testDataRead() throws IOException{
        FileInputStream fis = new FileInputStream("data.dat");
        DataInputStream dis = new DataInputStream(fis);
        int a = dis.readInt();
        String s = dis.readUTF();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();
        char c = dis.readChar();
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
        System.out.println(b);
        System.out.println(s);
        dis.close();
        fis.close();
        //读写顺序必须一致
    }
```
