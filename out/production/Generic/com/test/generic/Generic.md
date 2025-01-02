# Generic
## 泛型：泛化的类型
1. 生活中：
- 生产瓶子的厂商，只负责上产瓶子，不管瓶子要装什么
- 在超市中，瓶子有标签，表明这个瓶子中是什么
2. java中
- 例如：在设计集合这个容器的数据结构时，不知道我们程序员用它来装什么对象，可能装字符串对象，也可能是其他对象
- 在设计时不确定元素的类型，但是在使用时，程序员知道类型
- 现在需要一个方式让使用者在使用这个集合等时，告知这个集合里面装的是什么，就需要泛型
3. 泛型：
- 包括类型形参和类型实参
- 语法格式：<类型>
  - 例如：<String>、<Integer>
## 泛型的好处
```java
class Test1{
  public void test2(){
    //求两数之和
    //在完成这个功能的时候，不确定，要求的两个整数的值，我通过形参让调用者告诉我整数的值
    //a，b叫做形参，调用时由实参赋值
    //为了区别，把a和b成为数据形参，因为a和b穿的是数据值，不是类型
    ArrayList<String> list = new ArrayList();
    list.add("红楼梦");
    list.add("水浒传");
    list.add("西游记");
    //        list.add(3);//直接报错，因为限定了String类型
    //此时不需要用Object处理了，因为他知道里面的元素是String
    for(Object obj:list){
      System.out.println(obj);
    }
  }
}

```
## 泛型的使用形式
- 泛型的使用形式有两种
1. 泛型类、泛型接口
- 语法格式：【修饰符】 class 类名<泛型形参列表>{}
- 【修饰符】 interface 接口名<泛型形参列表>{}
- public Interface Collection<E>  <E>就是泛型形参列表
- public class ArrayList<E>  <E>就是泛型形参列表
- 我们看到在声明类或者接口时，<E>,<K,V>,<T>...等等都是泛型的形参列表
- 这些E,K,V等代表的是某种元素的类型
- 例如：`HashMap<String,Integer> map = new HashMap<String,Integer>();
- 此时的<String,Integer>是泛型的形参列表
- 要求：泛型的实参必须是引用数据类型，不能是基本数据类型
- 代码示例：

```java
import org.junit.jupiter.api.Test;

public class test1() {

  public static void main(String[] args) {
    public void test3 () {
      Students<String> s1 = new Students<String>("张三", "优秀");
      Students<Integer> s2 = new Students<Integer>("李四", 66);
      Students<Character> s3 = new Students<Character>("王五", 'A');
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
    }
  }
}

class Students<T> {
  private String name;
  private T score;

  public Students() {

  }

  public Students(String name) {
    this.name = name;
  }

  public Students(T score) {
    this.score = score;
  }

  public Students(String name, T score) {
    this.name = name;
    this.score = score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(T score) {
    this.score = score;
  }

  public String getName() {
    return this.name;
  }

  public T getScore() {
    return this.score;
  }

  @Override
  public String toString() {
    return "Students{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
  }
}
```
- 如何为泛型类、泛型接口制定泛型实参
  - 创建泛型类的对象时
  - `Students<String> chinise = new Students<String>("张三","优秀")`
  - 继承泛型类、泛型接口时可以指定泛型实参
  - `class ChineseStudents extends Students<String>`
  - 实现泛型接口时，可以指定泛型实参
  - `class Employee implements Comparable<Employee>`
- 补充：泛型类或泛型接口<泛型形参>这个类型可以用在哪些地方
  - 用于当做属性的数据类型
    - 用于当做方法的数据形参类型
    - 可以用于返回值类型
    - 可以用作局部变量类型
  - 不能用于：
    - 静态成员
- 泛型类或泛型接口的泛型形参可以设定上限
  - `Students<T extends Number>`只能是Number类型或者Number类型的子类
- 泛型的形参一般代表什么的类型？
  - ArrayList<E>:这个E代表的集合的元素的类型
  - Map<K,V>:这个K代表key的类型，V代表value的类型
  - Comparable<T>:这个T代表，要与当前对象比较的另一个对象的类型
- 如果在使用泛型类或泛型接口的时候，没有指定泛型实参，会怎么样
  - 泛型被擦除，泛型被擦除后，泛型形参被解析为泛型形参的第一个上限类型
  - 如果没有指定泛型形参的上限，就按照Object处理
  - 如果指定了泛型的上限就按照上限执行
  - `<T extends Number&Comparable&Serilizable>`这种多种上限类型的实参要求，同时是Number的子类，还要实现Comparable和Serializable接口
2. 泛型方法
- 什么情况需要声明泛型方法？
  1. 如果某个静态方法需要使用泛型，需要单独设计
  2. 如果泛型类或泛型接口上的形参不适用于某一个方法（可以是静态的，也可以是非静态），那么这个方法，可以单独设计泛型
    - 例如java.util.Arrays数组工具类
- 泛型方法的语法格式
  1. 【修饰符】<泛型形参列表> 返回值类型 方法名(【数据形参列表】)
- 泛型方法的类型形参，什么时候指定类型实参
  - 当你调用这个方法时，编译器会根据方法的实参的类型，来确定泛型的实参的类型
- 泛型方法的<泛型形参列表>这个类型就用于当前方法的形参类型，返回值类型、局部变量，和其他方法无关
- 泛型方法的<泛型实参列表>中的类型也可以指定上限
```java
    public void test5(){
        test6(1);
        test6(1.0);
//        test6("张三");//错误
    }
    public <T extends Number> T test6(T t){
        return t;
    }
```
## 泛型的通配符
1. 通配符：？
- <?>：代表可以使任意类型
- <? extends 上限>？代表的是上限或上限的子类
```java
    public void test9(){
        ArrayList<String> list = new ArrayList<String >();
//        printGraphic(list);//错误的
        ArrayList<Circle> list1 = new ArrayList<Circle>();
        printGraphic(list1);
    }
    public void printGraphic(Collection<? extends Graphic> graphic){
        for(Object obj:graphic){
            System.out.println(obj);
        }
    }
```
- <? extends 下限>？代表的是下限或下限的父类
  - 这里的super可以理解为超脱
```java
    @Test
    public void test10(){
        //把一个Collection集合的元素，添加到另一个Collection集合dest中
        Collection<String> src = new ArrayList<String>();
        src.add("hello");
        src.add("java");
        Collection<Integer> dest = new ArrayList<Integer>();
        dest.add(1);
        dest.add(2);
//        copy(src,dest);//错误的
        Collection<Object> dest1  = new ArrayList<Object>();
        copy(src,dest1);
    }

    public <T>void copy(Collection<T> src,Collection<? super T> dest){
        for(T obj : src){
            dest.add(obj);
        }
    }
```
2. 泛型在指定时，两边必须相同
```java
    public void test7(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        print(list);
    }
    public void print(Collection<?> c){
//    public void print(Collection<Object> c){//这个是错误的
        for(Object obj:c){
            System.out.println(obj);
        }
    }
```
## 集合工具类
1. java.util.Collections：集合工具类
- public static boolean disjoint(Collections<?> c1,Collections<?> c2)看c1和c2是否有交集，如果没有交集，返回true
```java
    public void test8(){
        Collection<String> c = new ArrayList<String>();
        c.add("张三");
        Collection<Integer> c1 = new ArrayList<Integer>();
        c1.add(1);
        System.out.println(Collections.disjoint(c, c1));
    }
```
- public static <T> boolean addAll(Collection<?super T> c,T... elements):
- 把elements这些元素添加到c这个集合中
```java
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        ArrayList<Number> list3 = new ArrayList<Number>();
        //此时T是Integer类型
        //<? super T>:可以是Integer或者他的父类
        Collections.addAll(list,1,2,3,4);
        Collections.addAll(list,1,2,3,4);
        Collections.addAll(list2,1,2,3,4);//Number和Object都可以都是Integer的父类
        Collections.addAll(list3,1,2,3,4);
//        Collections.addAll(list2,1,2,3,4);//错误的
    }
```
- public static <T> int binarySearch(List<? extends T> list, T key,Comparator<? super T> c)
  - 在list集合中找出key用二分查找法要求list集合有大小顺序
  - List<? extends T> list, T key,Comparator<? super T> c ：在list集合中的元素必须是实现Comparable接口，？可以是T或者T的父类
  - 要求list集合要有大小顺序，按照指定的Comparator进行比较大小
  - <? extends T>:是T或者T的子类，说明list中存的元素是T类型的对象或子类对象
  - <? super T>:这个比较器是为T或T的父类设计的比较器也可以
- public static <T> void copy(List<? super T> dest, List<? extends T> src)
  - 把src的元素复制到dest
  - src存的是T或T的子类对象
  - dest存的是T或T的父类对象
- public static <T extends Object & Comparable<? super T>>T max(Collection<? extends T> coll)
  - <T extends Object & Comparable<? super T>>T是max方法的泛型形参列表，泛型形参T，设定了上限，说明T必须继承Object，并且要实现Comparable接口
  - max方法用于在coll集合中找出最大的元素，要求这个元素可以比较大小，所以要求T元素实现Comparable接口
- public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
  - 如果这个coll中的元素不支持自然比较大小，那么用comp这个定制比较器比较元素大小
- public static void reverse(List<?> list)
  - 可以翻转任意的List的集合元素
- public static void shuffle(List<?> list)
  - 类似于洗牌