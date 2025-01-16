# Stream
- 创建：一步
- 中间：0-n步
- 终结：一步
## Stream的API
1. Stream的API是用来处理数据，处理集合等容器中的数据，处理操作有：查询、筛选、删除、过滤、统计、映射等
希望能够用类洗浴SQL语法的形式对java内存中的数据进行处理
2. Stream本身并不负责处理数据，存储数据是用集合，数组等数据结构
Stream只负责对数据进行加工
3. Stream的操作分为三步
- 创建Stream，告知Stream数据的来源是哪里
- 加工数据：这个过程可以有很多种
- 终结操作：搜集结果
- 一旦终结就不能在加工了，如果要加工需要重新创建Stream
- Stream是不可变的，一旦修改就会产生新的Stream对象
4. Stream的特点
- Stream本身并不负责处理数据，存储数据是用集合，数组等数据结构
- Stream是不可变的，一旦修改就会产生新的Stream对象
- Stream的操作是一个延迟操作，所有的操作都必须延迟到终结操作时，一起处理
- Stream不会修改数据源的数据
```java
public class Test06Stream {
	@Test
	public void test01(){
		ArrayList<Employee> list= new ArrayList<>();
		list.add(new Employee(1,"张三"));
		list.add(new Employee(1,"张三"));
		
		Stream<Employee> stream = list.stream();
		stream = stream.distinct();//处理，中间操作  
		long count = stream.count();//统计个数   终结操作
		System.out.println(count);
		System.out.println("over");
		System.out.println("--------------------");
		//重新遍历list
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}
}
class Employee{
	private int id;
	private String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("比较....");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

```
## 创建Stream流
1. 通过集合创建
- 集合对象.stream
```java
    public void test(){
    List<Integer> list = Arrays.asList(1,2,3,4,5);
    Stream<Integer> s = list.stream();
//        s.forEach(System.out::println);
    s.forEach((num)->{
        System.out.println(num);
    });
}
```
2. 通过数组工具类Arrays
- Arrys.stream(数组对象)
```java
    public void test2(){
        int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        //        s.forEach(System.out::println);
        stream.forEach((num)->{
            System.out.println(num);
        });
    }
```
3. Stream接口的静态of方法，产生一个有限流
```java
    public void test3(){
        //产生一个有限流
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        stream.forEach(System.out::println);
    }
```
4. Stream接口的静态generate方法，产生一个无限流
- 还有一个方法是 Stream.Iterate
```java
public void test5(){
        Stream<Integer> stream = Stream.iterate(1,(num)->{
            return num += 2;
        });
        stream = stream.limit(10);
        stream.forEach(System.out::println);
    }
```
## Stream中间操作
1. filter:过滤
```java
    public void test1(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        stream = stream.filter(t->t%2==0);//必须要接收
        stream.forEach(System.out::println);
    }
```
```java
    public void test2(){
        Stream.of(1,2,3,4,5,6).filter(t->t%2==0).forEach(System.out::println);
    }
```
2. distinct：去重
```java
    public void test3(){
        Stream.of(1,2,3,5,4,6,5,87,9,5,65,5,5,51,93).distinct().filter(t->t%2==0).forEach(System.out::println);
        Stream.of(1,2,3,5,4,6,5,87,9,5,65,5,5,51,93).distinct().forEach(System.out::println);
    }
```
3. limit：取有限的几个
```java
    public void test4(){
        Stream.of(1,3,5,35,5,6,44,5,506,58,22,5,9,3,2,2,1,5,3,5,227,9,6).
        distinct().
        filter(t->t%2!=0).
        limit(3).forEach(System.out::println);
    }
```
4. skip：跳过几个
```java
    public void test5() {
        Stream.of(1, 3, 5, 35, 5, 6, 44, 5, 506, 58, 22, 5, 9, 3, 2, 2, 1, 5, 3, 5, 227, 9, 6).
                distinct().
                filter(t -> t % 2 != 0).
                skip(3).
                limit(3).forEach(System.out::println);
    }
```
> 运行结果：35 9 227
5. peek：接受Lambda，对流中的每个数据执行Lambda体操作
- 当你又想打印又想做其他操作的时候可以用peek
```java
    public void test6(){
        long count = Stream.of(1, 3, 5, 35, 5)
                .distinct()
                .peek(System.out::println)
                .count();
        System.out.println(count);
    }
```
> 运行结果：1 3 5 35是peek的结果
> 4是count
6. sorted()：自然排序
    sorted(Comparator com)：定制排序
```java
    public void test7(){
        Stream.of(1, 3, 5, 35, 5, 6, 44, 5, 506, 58, 22, 5, 9, 3, 2, 2, 1, 5, 3, 5, 227, 9, 6)
                //找最大的三个不重复的
                .distinct()
//                .sorted()//这是按照从小到大排序
                .sorted((t1,t2 )->- Integer.compare(t1,t2))
                .limit(3)
                .forEach(System.out::println);
    }
```
> 运行结果：506 227 58
7. map(Function f)：接收Lambda表达式，对流中的每个数据，执行Lambda体的操作，返回新的数据构成新的流
```java
    public void test8(){
        Stream.of(1,2,3,4,5)
                .map((t)->{
                    return t*2;
                })
                .forEach(System.out::println);
    }
```
> 运行结果：2 4 6 8 10
8. flatMap(Function f)
- map操作流中的把T对象变成R对象，由R对象构成新的流
- flatMap把流中的数据T对象呀变成一个Stream，然后把一个个的Stream最后合成一个大的Stream
```java
    public void test9(){
        String[] arr = {"hello","world","java"};
        Stream<String> flatMap = Arrays.stream(arr)
                .flatMap(t->Stream.of(t.split("|")));
        flatMap.forEach(System.out::println);
    }
```
> 运行结果：h e l l o w o r l d j a v a
> 把这三个单词拆成了三个小流，合成一个大流
## Stream的终结操作
1. void forEach：遍历流中的数据
2. long count：流中的数据个数
```java
    @Test
    public void test(){
        Stream.of(1,2,3,4,5,6)
                .forEach(System.out::println);
    }
    @Test
    public void test2(){
        long count = Stream.of(1,2,3,4,5,6)
                .count();
        System.out.println(count);
    }
```
3. boolean allMatch：是否全部满足lambda体的条件
```java
    @Test
    public void test3(){
        boolean result = Stream.of(1,3,5,7,9)
                .allMatch(t->t%2!=0);
        System.out.println(result);
    }
```
> true
4. boolean anyMatch：是否有一个满足lambda体的条件
```java
    public void test4(){
        boolean result = Stream.of(1,3,6,7,9)
                .anyMatch(t->t%2!=0);
        System.out.println(result);
    }
```
> true
5. boolean anyMatch：是否全部不满足lambda体的条件
```java
    public void test5(){
        boolean result = Stream.of(1,3,6,7,9)
                .noneMatch(t->t%2!=0);
        System.out.println(result);
    }
```
> false
6. Optional<T> findFirst()：返回第一个
- 没有回返回空
```java
    public void test6(){
        Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
                .filter(t->t%3 == 0)
                .findFirst();
        System.out.println(opt);
    }
```
> Optional[3]
7. Optional<T> findAny()：返回任意一个，是稳定的就返回第一个，不是就返回任意一个
```java
    public void test7(){
    Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
            .filter(t->t%3 == 0)
            .findAny();
    System.out.println(opt);
}
```
> Optional[3]
8. max：找出最大的
```java
    public void test8(){
        Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
                        .max((t1,t2)->Integer.compare(t1,t2));
        System.out.println(opt);
    }
```
> Optional[6]
9. min：找出最小的
```java
    public void test8(){
    Optional<Integer> opt = Stream.of(1,2,3,4,5,6)
            .min((t1,t2)->Integer.compare(t1,t2));
    System.out.println(opt);
}
```
10. reduce:通过反复运算留下最终结果
```java
    public void test9(){
        Optional<Integer> reduce = Stream.of(1,2,3,4,5,6)
                .reduce((t1,t2)->t1+t2);
        System.out.println(reduce);
    }
```
11. collect(收集器，提供的收集器是一个接口)：把流中的数据都收集到一起
```java
    public void test10(){
        List list = Stream.of(1,2,3,4,5,6)
                .filter(t->t%2 == 0)
                .collect(Collectors.toList());
        System.out.println(list);
    }
```
> [2, 4, 6]
## Option
- Optional实际上是一个容器对象，他是一个装一个对象的容器。这个对象可能是个空，可能是非空。<br/>数组和集合是装多个对象的容器
1. Optional.of(xx)：创建容器，只能装非空对象
```java
    public void test(){
        String s = "hello world";
        Optional<String> opt = Optional.of(s);
        System.out.println(opt);
    }
```
> Optional[hello world]
2.  Optional.ofNullable(xx)：可以装null对象
3. Optional empty()：直接返回空对象
## 如何取出容器中的对象
1. get():必须配合of(xx)使用，因为这里面的对象不能是null
2. orElse()：如果Optional容器中的对象是空的，用other代替
```java
    public void test2(){
        String s = null;
        Optional<String> opt = Optional.ofNullable(s);
        String s1 = opt.orElse("结果为空");//如果是空的，返回orElse括号内的内容
        System.out.println(s1);
    }
```
> 结果为空
4. orElseGet():如果Optional容器中的对象是空的，用other这个供给型接口提供的对象代替
```java
    public void test3(){
        String s = null;
        Optional<String> opt = Optional.ofNullable(s);
        String s1 = opt.orElseGet(String::new);
        System.out.println(s1);
    }
```
5. orElseThrow():抛出自定义异常
```java
    public void test4(){
        String s = null;
        Optional<String> opt = Optional.ofNullable(s);
        String s1 = opt.orElseThrow(()->new RuntimeException("值不存在"));
        System.out.println(s1);
    }
```