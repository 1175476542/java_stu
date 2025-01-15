## Lambda表达式（类似于箭头函数）
- Lambda表达式是函数式编程的风格，是为了给SAM接口的变量和形参赋值的一种语法
- 目的：为了减少代码的冗余，增加可读性
- SAM（Single Abstract Method）接口是一个只包含一个抽象方法的接口。
1. Runnable接口符合SAM的特征：public abstract void run();
```java
package com.test.lambda;

import org.junit.jupiter.api.Test;

public class LambdaTest {
    @Test
    public void test(){
        /*
        * 开启一个线程，这个现成的任务就是打印
        * 非lambda表达式方式实现
        * 要求实现Runable的接口方式来创建多线程
        * */

        TestRunable tr = new TestRunable();
        Thread t = new Thread(tr);
        t.start();
    }
    @Test
    public void test2(){
        //匿名内部类
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类打印结果");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
    @Test
    public void test3(){
        /*
        * 匿名内部类另一种方式
        *
        * */
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类另一种方式");
            }
        });
        t.start();
    }
    @Test
    public void test4(){
        /*
        * 更简洁的匿名内部类
        * */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("更简洁的匿名内部类");
            }
        }).start();
    }
    @Test
    public void test5(){
        /*
        * lambda表达式
        * 箭头函数实现
        * 箭头函数后面的大括号可以省略（如果只有一句代码）
        * */
        new Thread(()->{
            System.out.println("Lambda表达式的打印");
        }).start();
    }
}
class TestRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("打印结果");
    }
}
```
2. Comparator也符合SAM接口的特征：`public abstruct int compare(T t1,T t2)`
## 之前学习的接口和java8新增的函数式接口
1. 函数式接口：SAM接口
- Single Abstract Method，即该接口中只有一个抽象方法需要实现，当然该接口可以包含其他非抽象方法（默认方法和静态方法，或者是从Object继承的方法）。
2. 之前学过的接口：

|  描述   |                   接口                    |
|:-----:|:---------------------------------------:|
|  线程   |                Runnable                 |
|  比较   |               Comparable                |
| 定制比较  |               Comparator                |
|  集合   | Collection，Set，List，Map，Queue，Deque.... |
|  迭代器  |                Iterator                 |
|  迭代器  |                Iterable                 |
|  序列化  |              Serializable               |
| 反序列化  |             Externalizable              |
| 文件过滤器 |               FileFilter                |
|  反射   |            InvocationHandler            |
2. 哪些是符合SAM特征？

|    接口    |                   语法                    |
|:--------:|:---------------------------------------:|
| Runnable |            public void run()            |
|    Comparable    |               public int compareTo(T t)                |
|   Comparator   |               public int compare(T t1, T t2)                |
|    Iterable    | public Iterator iterator() |
|   FileFilter    |                public boolean accept(File pathname);                 |
|   InvocationHandler    |                public Object invoke(Object proxy, Method method, Object[] args)                 |
- 按照语法来说，只要符号SAM特征的接口，都可以使用Lambda表达式。
但是Java建议只针对标记了@FunctionalInterface这注解的SAM接口使用Lambda表达式

3. 上面哪些标记了@FunctionalInterface注解：\

|接口 |语法|
|::|:--:|
|Runnable| public void run()|
|Comparator| public int compare(T t1, T t2)|
|FileFilter| public boolean accept(File pathname);|
- 如果没有标记@FunctionalInterface注解的，说明它考虑了以后可能增加抽象方法。目前使用没问题，就是以后可能有风险。
4. Java8增加了大量的函数式接口给我们使用，而且基本上能满足常规的所有情况。
这些函数式接口集中在java.util.function包中。
5. 四大类接口：

|类型|                    描述                    |          其他           |
|:--:|:----------------------------------------:|:---------------------:|
|消费型接口|            它的抽象方法有一个特征：有参无返回值            | 		例如：void accept(T t) |
|供给型接口|            它的抽象方法有一个特征：无参有返回值            |      例如：T get()       |
|判断型接口|    它的抽象方法有一个特征：有参有返回值，但是返回值类型是boolean    | 例如：boolean  test(T t) |
|功能型接口|它的抽象方法有一个特征：有参有返回值|   例如： R apply(T t)    |
## 各个接口的代表

|                接口类型                 |经典代表|                   延伸代表                   |                                    总结                                    |
|:-----------------------------------:|:--:|:----------------------------------------:|:------------------------------------------------------------------------:|
|                消费型接口                | Consumer<T> 抽象方法：void accept(T t)  | DoubleConsumer、BiConsumer、IntConsumer... |消费型接口都以Consumer单词为结尾;<br/>Bi开头，传两个参数Binary(二元的); <br/>xxConsumer，前面的xx代表的是形参类型 |
|                供给性接口                | Supplier<T>   抽象方法    T get()      | BooleanSupplier、IntSupplier ... |（1）供给型接口以“Supplier”单词结尾<br/>（2）xxSupplier说明返回xx类型的结果<br/>（3）供给型接口的抽象方法都是无参的|
|                判断型接口                | Predicate<T>  抽象方法    boolean test(T t)   |  BiPredicate、DoublePredicate、IntPredicate...       |（1）判断型接口以“Predicate”结尾<br/>（2）判断型接口抽象方法的返回值类型是固定的，是boolean<br/>（3）xxPredicate，说明形参是xx类型的 |
|                功能型接口                | Function<T,R>   抽象方法    R apply(T t)    |  UnaryOperator<T>、DoubleFunction<R>、ToDoubleFunction...             |（1）以Unary开头的，表示一元的，泛型的类型只有一个，形参和返回值都是同一种类型 <br/>（2）xxFunction，说明形参的类型是xx类型的 <br/>（3）toXXFunction，说明返回值类型是xx类型 <br/>（4）xxToyyFunction，说明形参的类型是xx类型的,返回值类型是yy类型<br/>（5）xxUnary开头的，表示一元，形参类型和返回值类型都是xx <br/>（6）Bi开头，表示二元，形参类型是2个<br/>（7）BinaryOperator，既是Bi开头表示两个形参，又是Operator结尾，表示形参和返回值类型是一样<br/>（8）toXXBi开头的，表返回值类型是xx，并且形参是两个<br/>（9）xxBinaryOperator，表示两个形参，又是Operator结尾，表示形参和返回值类型是一样 |
## Lambda表达式的语法
- 匿名内部类：实现了这个接口，重写了接口的抽象方法，同时创建了对象
- Lambda表达式也要实现这个接口，重写接口的抽象方法，隐含的创建了对象
1. 语法格式：`(形参列表)->{Lambda体}`
2. 说明：
- 形参列表就是SAM接口抽象方法的形参列表
- Lambda体就是SAM接口抽象方法的方法体
- ->成为Lambda操作符，中间不能有空格
3. 优化：
- 如果Lambda体只有一句语句，可以省略大括号和分号，如果大括号没有省略那么分号就不能省略
- 如果形参列表中形参的类型是已知的，获取可以推断，那么这个数据类型可以省略
- 如果形参列表只有一个形参，并且数据类型也已经省略了，那么这个括号也可以省略，如果数据类型没有省略，括号不能省略
- 如果Lambda体只有一句语句，并且是一个return语句，那么可以省略大括号、分号和return
```java
    public void test(){
    ArrayList<String> list = new ArrayList<String>();
    list.add("你从丹东来");
    list.add("换我一城雪白");
    list.add("想吃广东菜");
    list.add("要记得将军的恩情");
    list.add("核爆近距离观察员");
    list.forEach((str)->{
        System.out.println(str);
    });
    list.forEach(str-> System.out.println(str));
    list.removeIf(str-> str.length()>6);
}
```
4. Supplier和Consumer
- java8中有一个新的类：Stream类型，他代表一个数据加工留
- static <T> Stream<T> generate(Supplier<T> s)
- 符合SAM接口
- Stream的Consumer方法，void accept(T t)
```java
    public void test(){
        Stream<Double> stream = Stream.generate(()->Math.random());
        stream.forEach(num -> System.out.println(num));
    }
```
## 自定义函数式接口
1. 声明一个接口，只能包含一个抽象方法 
2. 给这个接口加@FunctionanInterface
```java
package com.test.lambda;

public class TestDefineFunctionalInterface {
    public static void main(String[] args) {
        /*
        * 1.抽象方法：int cal(int a,int b);
        * 2. 如何实现抽象方法，例如：求a+b的和
        * */
        getSum(1,2,(int a,int b)->{return a+b;});
    }

    public static void getSum(int a,int b,CalTest tool){
        int cal = tool.Cal(a, b);
        System.out.println(cal);
    }
}
@FunctionalInterface
interface CalTest{
    int Cal(int a,int b);
}

```
> 个人理解：因为接口里面的是抽象方法，而抽象方法是没有方法体的，使用Lambda表达式小括号内传参，大括号内就是要做什么。<br/>例题中的tool是TestCal的类型，当调用TestCal这个类型的时候通过传入的a，b去找传入的箭头函数，找到需要做什么
## 方法引用和构造器引用
1. 条件：
- 当Lambda体的实现是通过调用一个现有的方法来完成功能时
- 要求函数式接口的抽象方法的形参列表与返回值类型与该方法的形参列表与返回值的类型要对应
- 要求函数式接口的抽象方法的形参列表与方法的形参列表对应
- 
2. 方法引用的语法格式：
- 对象::实例方法名
```java
    public void test(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        list.forEach((num)->{
//            System.out.println(num);
//        });//等价于下文
        list.forEach(System.out::println);
    }
```
- 类名::静态方法名
```java
    public void test2(){
        /*
        * Math.random返回的是double类型
        * Stream是泛型，可以限定为Double
        * */
        Stream<Double> stream = Stream.generate(()->{return Math.random();});
        Stream<Double> stream1 = Stream.generate(()-> Math.random());//等价于下文
        Stream<Double> stream2 = Stream.generate(Math::random);
    }
```
- 类名::实例方法名
```java
 public void test3(){
        String[] arr = {"java","hello","Java","world"};
        /*
        * 这里的
        * Comparator<String>接口 int compare(String s1,String s2)
        * String类的              int compareToIgnoreCase(String str)此处，s1正好是调用compareToIgnoreCase的对象，s2是给他的参数
        * */
        Arrays.sort(arr,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));
    }
```
3. 构造器引用
- 语法格式：
  - 类名::new
  - 数组类型::new
- 条件
  - 当Lambda体的实现是通过创建一个对象来实现的
  - 要求函数式接口的抽象方法返回值类型与该对象的类型一致
    - 要求函数式接口的抽象方法的形参列表与该对象创建时的构造器的形参列表对应