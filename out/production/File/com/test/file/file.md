# 文件
- java.io.file:类
- 文件和目录 路径名的抽象表示形式
- 通俗的讲File类的对象代表一个文件或一个目录（文件夹）
##  路径的分隔符
- windows：\或/
- 其他平台：/
- 或者file.seqarator
```java
    public void test1(){
        File file1 = new File("C:\\windows\\appData");
        File file2 = new File("C:/windows/appData");
        File file3 = new File("C:"+File.separator+"windows"+File.separator+"appData");
    }
```
## API
1. 获取文件详细信息
```java
    @Test
    public void test1(){
        File file1 = new File("C:\\windows\\appData");
        File file2 = new File("C:/windows/appData");
        File file3 = new File("C:"+File.separator+"windows"+File.separator+"appData");
        //新建目录对象
        File dir = new File("G:/java学习视频/鱼皮分享-保姆级Java系列资源/01-Java基础+Java高级/day22_全天上课资料");
    }
    @Test
    public void test2(){
        //API
        File dir = new File("G:\\java学习视频\\鱼皮分享-保姆级Java系列资源\\01-Java基础+Java高级\\day22_全天上课资料\\Java复习笔记.md");
        System.out.println("文件名：" + dir.getName());
        System.out.println("文件大小：" + dir.length());
        System.out.println("文件是否存在：" + dir.exists());
        System.out.println("文件的父文件：" + dir.getParent());
        System.out.println("文件是否可读：" + dir.canRead());
        System.out.println("文件是否可写：" + dir.canWrite());
        System.out.println("文件是否是隐藏文件：" + dir.isHidden());
        //返回父文件名称
        String parent = dir.getParent();
        //返回父文件对象
        File file = dir.getParentFile();
        System.out.println("文件的父目录："+parent);

        System.out.println("文件修改时间："+dir.lastModified()+"毫秒");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("文件上次修改时间为："+sf.format(new Date(dir.lastModified())));
    }
```
2. 获取文件路径
```java
    public void test3() throws IOException {
        //路径
        File file = new File("/file.md");//相对路径
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
    public void test4() throws IOException {
        //创建
        File file = new File("./test.txt");
        File file1 = new File("./test");
        File file2 = new File("./test1/test/test");
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
        File file = new File("./test.txt");
        File file1 = new File("./test");
        File file2 = new File("./test1/test/test");
        file.delete();

    }
```
- renameTo(File dest)：重命名为dest,文件和目录都可以
```java
    public void test6() throws IOException {
        //重命名
        File file = new File("./test.txt");
        File dest = new File("./test1.txt ");
        file.createNewFile();
        file.renameTo(dest);

    }
```
4. 判断是文件还是目录
- isFile()：判断是否是一个文件
- isDirectory：判断是否是文件夹
5. 