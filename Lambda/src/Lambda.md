## Lambda表达式
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
| 接口类型                               |经典代表|                   延伸代表                   |                                    总结                                    |
|:--:|---------------------------------|:--:|:----------------------------------------:|:------------------------------------------------------------------------:|
|消费型接口| Consumer<T> 抽象方法：void accept(T t)  | DoubleConsumer、BiConsumer、IntConsumer... |消费型接口都以Consumer单词为结尾;<br/>Bi开头，传两个参数Binary(二元的); <br/>xxConsumer，前面的xx代表的是形参类型 |
|供给性接口| Supplier<T>   抽象方法    T get()      | BooleanSupplier、IntSupplier ... |（1）供给型接口以“Supplier”单词结尾<br/>（2）xxSupplier说明返回xx类型的结果<br/>（3）供给型接口的抽象方法都是无参的|
|判断型接口| Predicate<T>  抽象方法    boolean test(T t)   |  BiPredicate、DoublePredicate、IntPredicate...       |（1）判断型接口以“Predicate”结尾<br/>（2）判断型接口抽象方法的返回值类型是固定的，是boolean<br/>（3）xxPredicate，说明形参是xx类型的 |
|功能型接口| Function<T,R>   抽象方法    R apply(T t)    |  UnaryOperator<T>、DoubleFunction<R>、ToDoubleFunction...             |（1）以Unary开头的，表示一元的，泛型的类型只有一个，形参和返回值都是同一种类型 <br/>（2）xxFunction，说明形参的类型是xx类型的 <br/>（3）toXXFunction，说明返回值类型是xx类型 <br/>（4）xxToyyFunction，说明形参的类型是xx类型的,返回值类型是yy类型<br/>（5）xxUnary开头的，表示一元，形参类型和返回值类型都是xx <br/>（6）Bi开头，表示二元，形参类型是2个<br/>（7）BinaryOperator，既是Bi开头表示两个形参，又是Operator结尾，表示形参和返回值类型是一样<br/>（8）toXXBi开头的，表返回值类型是xx，并且形参是两个<br/>（9）xxBinaryOperator，表示两个形参，又是Operator结尾，表示形参和返回值类型是一样 |
4. 