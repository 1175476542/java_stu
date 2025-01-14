# 反射
## 类加载概述
- 类的加载大多数情况下是1、2、3一起完成的，但是有的时候3初始化不一起完成
1. 加载
- 把字节码读取到内存
2. 连接
- 验证
- 准备
  - 例如：给类变量（静态变量）在方法区分配内存，并非final的赋默认值，但是如果是final的，直接赋常量值
  - 类似于前端var的变量提升
- 解析 
  - 虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程
- 这里1、2完成时，在方法区中已经有一个能够代表当前类的Class对象
3. 类的初始化<clinit>
- 是由编译器自动收集1.静态变量的显式赋值2.静态代码块的内容的组成
- 当一个类初始化时，如果他的父类没有初始化，，那么会先初始化父类
## 触发类初始化和不触发的操作
### 触发
1. 类的加载包含类的初始化一起完成
- 当虚拟机启动，先初始化main方法所在的类
- 当初始化一个类，如果其父类没有被初始化，则会先初始化他的父类
- new一个对象，第一次使用就是创建他的对象
- 使用一个类的静态成员（包含静态变量和静态的方法），但是这个静态的变量不能是final
- 使用java.lang.reflect包的方法对类进行反射调用
### 不触发
1. 引用静态变量不会触发此类的初始化（final）
```java
class D{
    public static final int NUM = 10;//去掉final会触发类的初始化
    static {
        System.out.println("D类初始化");
    }
}
```
2. 当访问一个静态域（静态变量、静态方法）时，只有真正声明这个域的类才会被初始化
- 即当通过子类引用父类的静态变量、静态方法时，不会导致子类初始化
```java
class E{
    public static int num = 10;
    static {
        System.out.println("E父类的初始化");
    }
    public static void test(){
        System.out.println("E静态方法不会导致F子类初始化");
    }
}
class F extends E{
    static {
        System.out.println("F子类的初始化");
    }

}
```
3. 通过数组定义类的引用，不会触发此类的初始化
- 通过A[]创建的是一个数组对象，所以根本没有创建A的实例，所以也不会触发类的初始化
```java
A[] a = new A[10];


class A{
    static {
        System.out.println("A类的初始化");
    }
}
```
## 类加载器的类型
1. 引导类加载器（Bootstrap ClassLoader）：又称为根类加载器
- 加载java的核心库（JAVA_HOME/jre/lib/rt.jar等或sun.boot.class.path路径下的内容）
- 是用原生代码（C\C++）来实现的，并不集成java.lang.ClassLoader，所以通过java代码获取引导类加载器对象将会得到null
2. 如何获取某个类的类加载器对象
```java
    @Test
    public void test(){
        Class clazz = Test1.class;
        ClassLoader cl = clazz.getClassLoader();
        System.out.println(cl);//不是null，就不是引导类加载器
    }
    @Test
    public void test2(){
        Class clazz = String.class;
        ClassLoader cl = clazz.getClassLoader();
        System.out.println(cl);//这里是null，所以String的加载器是引导类加载器
    }
```
3. 扩展类加载器（Extension ClassLoader）
- 负责加载java的扩展库（JAVA_HOME\jre\ext\*.jar）或java.ext.dirs路径下的内容
- sun.misc.Launcher$ExtClassLoader
4. 应用程序类加载器(Application ClassLoader)
- 它负责加载项目的classpath、java.class.path路径下的内容
- 它是ClassLoader的子类
- 通俗的将：项目的路径bin文件夹下的字节码，以及如果你配置了环境变量classpath
5. 自定义类加载器
- 什么情况下定义
  - 字节码需要加密或解密
  - 字节码的路径不在常规路径，有自定特定的路径（例如Tomcat）
## java中类加载器的双亲委托模式
- 类加载设计时，这四种类加载器是有层次结构的，但是这层次结构不是通过继承关系来实现的
- 但是是通过组合的方式来实现“双亲”的认亲过程
- 例如应用程序类加载器把扩展类加载器成为父加载器，在应用程序类加载器中保留应用程序类加载器的一个引用，成员变量
把变量名称设计为parent
- 所有类加载器都有一个getParent()，获取父加载器的方法
1. 这些加载器的目的
- 为了安全，并且各司其职
- 当应用程序类加载器接到某个任务时
  - 1. 会先在内存中搜索这个类是否加载过了，如果是，就返回这个类的Class对象，不去加载
  - 2. 如果没有找到，会把这个任务先提交给父加载器
- 当扩展类加载器接到某个任务时
  - 1. 会先在内存中搜索这个类是否加载过了，如果是，就返回这个类的Class对象，不去加载
  - 2. 如果没有找到，会把这个任务先提交给父加载器
- 当引导类加载器接到某个任务时
  - 1. 会先在内存中搜索这个类是否加载过了，如果是，就返回这个类的Class对象，不去加载
  - 2. 如果没有找到，即没加载过。会在他的负责的范围内尝试加载
    - 如果可以找到，那么就返回这个类的Class对象，就结束了
    - 如果没有找到，那么会把这个任务往回传，让子加载器（扩展类加载器）去加载
    - 子加载器（扩展类加载器）接到父加载器返回的任务后，娶她负责的范围内加载
      - 如果可以找到，那么就返回这个类的Class对象，就结束了
      - 如果没有找到，那么会把这个任务往回传，让子加载器（应用程序类加载器）去加载
    - 子加载器（应用程序类加载器）接到父加载器返回的任务后，娶她负责的范围内加载
      - 如果可以找到，那么就返回这个类的Class对象，就结束了
      - 如果没有找到，那么就报错
- java中会认为：不同加载器加载类名相同的类，会识别为不同的类
## 类加载器的作用
1. 本职工作：加载类
2. 可以用来加载“类路径下”的资源文件
- 例如：src下的（编译后对应bin）
3. 加载资源文件的路径问题
- 不能是静态的，不然在不同环境下路径不同，会出问题
- 可以先通过getResourceAsStream类加载器去加载文件路径
- 再通过properties去load资源文件路径
```java
//只针对资源文件在src文件目录下
    public void test2() throws IOException {
        Properties pro =  new Properties();//集合、map、键值对
        Class clazz = LoadJDBC.class;
        ClassLoader loader = clazz.getClassLoader();
        InputStream in = loader.getResourceAsStream("jdbc.properties");
        pro.load(in);
        System.out.println(pro);
        System.out.println(pro.getProperty("\"username\""));
    }
```

```java
//资源文件在包里，需要加上包路径
public void test3() throws IOException {
  Properties pro =  new Properties();//集合、map、键值对
  Class clazz = LoadJDBC.class;
  ClassLoader loader = clazz.getClassLoader();
  InputStream in = loader.getResourceAsStream("com/test/reflection/data.properties");
  pro.load(in);
  System.out.println(pro);
  System.out.println(pro.getProperty("username"));
}
```

```java
//当资源文件在项目的根目录下
public void test4() throws IOException{
  //使用new FileInputStream
  Properties pro = new Properties();
  pro.load(new FileInputStream("data.properties"));
  System.out.println(pro);
  System.out.println(pro.getProperty("username"));
}
```
4. 如果项目资源在资源包（source folder）内，可以直接写文件名，不需要写资源包路径
## Class对象
1. 所有的java类型（包括基本数据类型、引用数据类型、void）
被加载到内存后，或者是编译器自动编译生成的class字节码，最终都会用一个Class对象来表示
即，所投的java类型，在内存中都表示为一个Class对象
2. 如何获取Class对象
  1. 类型名.Class
  - 优点：最简洁
  - 缺点：要求编译期间这个类型就存在
```java
    public void test1() {
        Class c1 = int.class;//基本数据类型
        Class c2 = void.class;//特殊的空类型
        Class c3 = String.class;//系统定义的类类型
        Class c7 = ClassObject.class;//自定义的类类型
        Class c8 = Serializable.class;//接口类型
        Class c4 = ElementType.class;//枚举类型
        Class c5 = Override.class;//注解类型
        Class c6 = int[].class;//数组类型
//        System.out.println(c1);
    }
```
  2. 对象.getClass()
  - 这个方法在java.lang.Object类型中声明的，返回对象的运行时类型
  - 适用于先有对象
```java
    public void test2(){
        Class c1 = "".getClass();
    }
```
  3. Class.forName("类型全名称")
  - 类型全名称：包.name
  - 优势：这个类型可以在编译期间未知，这个类名称可以在代码中出现，也可以在配置文件中，或者键盘输入等方式来指定
```java
    public void test3() throws ClassNotFoundException {
        Class c1 = String.class;
        Class c2 = "".getClass();
        Class c3 = Class.forName("java.lang.String");
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }
```
  4. 使用类加载器对象.loadClass("类型全名称")
  - 一般使用在自定义类加载器对象去加载指定路径下的类
```java
    public void test4() throws ClassNotFoundException {
        Class c1 = ClassObject.class;
        ClassLoader cl = c1.getClassLoader();
        Class c2 = cl.loadClass("com.test.reflection.TestClass");
        Class c3 = TestClass.class;
        System.out.println(c3 == c2);
    }
```
2. 四种方式都可以加载，看情况选择
## 反射的API
- 声明类-->创建对象
- 获取Class对象-->创建对象
- Class对象比喻为镜子中的那个影像
1. 反射的作用：运行时区别与编译时
- 在运行时能够获取任意类型的详细信息
- 在运行时能够创建任意引用数据类型的对象
- 在运行时可以为任意对象的属性赋值，或者获取任意对象的任意属性的值
- 在运行时可以调用任意对象的任意方法
- 在运行时读取某个注解信息
- 在运行时读取某个类的泛型实参
......
2. 步骤：
- 获取这个类的Class对象
- 获取类的信息
①包名
②类名
③类的修饰符
- Modifier
④直接父类
⑤父接口们
⑥属性们
⑦构造器们
⑧方法们
3. 切皆对象：
（1）所有类型在内存中都是Class对象
（2）所有的属性都是Field对象
- private int age;
- 属性类型：Field类型
*
4. 类的概念：一类具有相同特性的事物的抽象描述。
- 所有的属性，有没有相同特征：
  - 修饰符、数据类型、名称
  - 都有相同的行为操作：get获取值/set设置值
  - 所以把属性抽象为Field类，那么一个属性被加载到内存后，是用一个Field对象表示的。
（3）所有的构造器都是Constructor的对象
- 所有的构造器都有：
  - 修饰符，名称，形参列表
  - 都能 new 对象
- 所以把构造器抽象为Constructor类，那么一个构造器被加载到内存后，是用一个Constructor对象表示的。
（4）所有的方法都是Method对象
- 所有的方法都有：
  - 修饰符、返回值类型、方法名、形参列表、抛出的异常列表
  - 都能  被调用invoke
## API
1. getPackage:得到包名
```java
        Package pkg = clazz.getPackage();
        System.out.println("包名：" + pkg.getName());
```
2. 得到类名
```java
System.out.println("类名：" + clazz.getName());
```
3. 类的修饰符
```java
        int mod = clazz.getModifiers();
        System.out.println("修饰符的值：" + mod);
        System.out.println("修饰符：" + Modifier.toString(mod));

```
4. 父类名称
```java

        Class sc = clazz.getSuperclass();
        System.out.println("父类的名称：" + sc.getName());

```
5. 接口们
```java
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("父接口们：");
        for (Class inter : interfaces) {
            System.out.println(inter.getName());
        }
```
6. 得到属性
```java
//每一个属性就是一个Field的对象
        /*
         * (1)Field[] getFields() 得到所有公共的属性
         * (2)Field[] getDeclaredFields() 得到所有声明的属性
         */
        Field[] fields = clazz.getDeclaredFields();
        int count = 0;
        for (Field field : fields) {
            count++;
            int fMod = field.getModifiers();
            System.out.println(count + "：属性的修饰符：" + Modifier.toString(fMod));

            System.out.println(count + "：属性的数据类型：" + field.getType().getName());

            System.out.println(count + "：属性的名称：" + field.getName());
        }
```
7. 构造器
```java
  /*
         * Constructor[]  getConstructors()：得到所有的公共的构造器
         * Constructor[]  getDeclaredConstructors()()：得到所有的声明的构造器
         */
        count = 0;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            count++;
            int cMod = constructor.getModifiers();
            System.out.println(count + "：构造器的修饰符：" + Modifier.toString(cMod));
            System.out.println(count + "：构造器的名称：" + constructor.getName());
            Class[] parameterTypes = constructor.getParameterTypes();
            System.out.println(count + "：构造器的形参列表：" + Arrays.toString(parameterTypes));
        }

```
8. 方法
```java
/* (1)Method[] getMethods(); 得到所有公共的方法
         * (2)Method[] getDeclaredMethods(); 得到所有声明的方法
         */
        count=0;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            count++;
            int mMod = method.getModifiers();
            System.out.println(count + "：方法的修饰符：" + Modifier.toString(mMod));
            System.out.println(count +"：方法的返回值类型：" + method.getReturnType());
            System.out.println(count + "：方法的名称：" + method.getName());
            System.out.print(count + "：抛出的异常类型们：");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            System.out.println(Arrays.toString(exceptionTypes));
            Class[] parameterTypes = method.getParameterTypes();
            System.out.println(count + "：方法的形参列表：" + Arrays.toString(parameterTypes));
        }
```
