# Stream
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
5. 