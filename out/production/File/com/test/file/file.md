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
4. 
