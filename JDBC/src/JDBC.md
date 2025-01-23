# JDBC
- Java Database Connectivity：Java数据库连接技术
- 通常值得是SUn为各大数据库厂商Java程序如何连接和操作他这个DBMS软件指定的统一的标准，
即公共接口，这个公共接口有各大数据库厂商提供实现类，这些实现类就构成了数据库驱动
- Java程序员编写Java代码时，只要面向接口编程就行了，运行时，把驱动实现类加到项目中即可
- Java程序员只要学习sun公司提供的jdbc的公共接口就行了
## 注册驱动三部曲
- 驱动下载网址：https://repo1.maven.org/maven2/mysql/mysql-connector-java/
1. 把jar包放在项目的libs中
2. 把jar添加到build path中：在jar包右键build path->add to build path
3. 在代码中注册驱动
## 代码编写步骤
1. 注册驱动（如果这步不做，编译不会报错，运行时会报找不到驱动的异常
- 报错:No suitable driver found for jdbc:mysql://localhost:3306/java_sql_stu
  at java.sql/java.sql.DriverManager.getConnection
2. 连接数据库：会用到DriverManage和Connection
3. 操作数据库：
- 增删改：会用到Statement和PreparedStatement
- 查询：会用到Statement和PreparedStatement和ResultSet
4. 断开连接，关闭各种资源
### 常用接口
- 在java.sql包和javax.sql包
1. Connection：连接
2. Statement和PreparedStatement：增删改查
3. ResultSet：接受和处理查询结果
### 辅助接口
DriverManage：驱动管理类
### 具体操作
1. url：统一资源定位符，通俗讲就是网址
- 是用来定位到哪台电脑上的哪种DBMS数据库软件，访问那个数据库，这个DBMS软件目前运行在哪个端口号，这个DBMS是否还需要其他的参数
- 标准url(mysql)：协议://主机名:端口号/资源路径-jdbc:mysql:主机名:端口号/数据库名?其它参数
- 例如：jdbc:mysql://localhost:3306/test
- 代码演示（增删改）
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
        Connection connection = DriverManager.getConnection(url,"root","Sirius@0615..");
        System.out.println(connection.getClass());
        //操作数据库
        //编写sql
        String sql = "insert into stu values(5,'sirius','男')";
        //准备一个statement
        Statement statement = connection.createStatement();
        //执行sql
        //增删改都用executeUpdate
        int len = statement.executeUpdate(sql);//返回的结果是一个整数：影响的记录数
        System.out.println(len>0?"添加成功":"添加失败");
        //释放资源
        statement.close();
        connection.close();


    }
}

```
- 代码演示（查询）
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelect {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
        String sql = "select * from stu";
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(sql);//结果集合，需要遍历
        System.out.println(result);
        //遍历结果集
        while (result.next()){
            int stuId = result.getInt("id");
            String stuName = result.getString("name");
            String stuGender = result.getString("gender");
            System.out.println("学号："+ stuId + "姓名：" + stuName + "性别：" + stuGender);
        }
    }
}

```
- 查询的另一种写法(直接写查询的列的index)
```java
import java.sql.*;

public class JDBCSelect {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
//        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
//        String sql = "select * from stu";
//        Statement st = conn.createStatement();
//        ResultSet result = st.executeQuery(sql);//结果集合，需要遍历
//        System.out.println(result);
//        //遍历结果集
//        while (result.next()){
//            int stuId = result.getInt("id");
//            String stuName = result.getString("name");
//            String stuGender = result.getString("gender");
//            System.out.println("学号："+ stuId + "姓名：" + stuName + "性别：" + stuGender);
//        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
        String sql = "select * from stu";
        Statement st= conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            int stuId = rs.getInt(1);
            String stuName = rs.getString(2);
            String stuGender = rs.getString(3);
            System.out.println("学号："+ stuId + "姓名：" + stuName + "性别：" + stuGender);
        }
    }
}

```
## Statement
### Statement存在的问题
- 可以使用Statement的子接口PreparedStatement
- PreparedStatement和Statement的区别是sql语句的位置
- 前者在execute函数里面，后者在创建PreparedStatement的位置
1. 在sql语句中插入变量(拼接问题)
- 解决代码
```java
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class TestPreparedStatement  {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入姓名：");
    String name = input.next();
    System.out.println("请输入性别：");
    String gender = input.next();
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/java_sql_stu";
    Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
    String sql = "insert into stu values (default,?,?)";
    PreparedStatement ps =conn.prepareStatement(sql);
    //需要加一部设置?的值
    ps.setString(1,name);//1表示的第一个?
    ps.setString(2,gender);//2表示第二个问号
    int len = ps.executeUpdate();
    System.out.println(len>0?"添加成功":"添加失败");
    ps.close();
    conn.close();
    input.close();
  }
}

```
2. sql注入
- 解决代码
```java
import java.sql.*;
import java.util.Scanner;

//防止sql注入
public class TestPreparedStatement2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = input.next();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
        String sql = "select * from stu where name = ?";
//        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        System.out.println(sql);

//        ps.setString(1,name);
        ResultSet result = ps.executeQuery();//结果集合，需要遍历
//        System.out.println(result);
        //遍历结果集
        while (result.next()){
            int stuId = result.getInt("id");
            String stuName = result.getString("name");
            String stuGender = result.getString("gender");
            System.out.println("学号："+ stuId + "姓名：" + stuName + "性别：" + stuGender);
        }
        ps.close();
        conn.close();
    }
}

```
3. 无法处理blob等二进制类型的数据
- 可以使用输入流
- 解决代码
```java
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPreparedStatementBlob3 {
    public static void main(String[] args) throws Exception {
        //往test库的t_userinfo标准添加一条记录
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sql_stu", "root", "Sirius@0615..");

        //3、编写sql
        String sql = "insert into stu values(null,?,?,?)";//避免了拼接blob

        //4、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //5、设置？
        pst.setString(1, "田曦薇");
        pst.setString(2, "女");
        pst.setObject(3, new FileInputStream("E:/存图/tianxiwei.webp"));

        //6、执行sql
        int len = pst.executeUpdate();
        System.out.println(len > 0 ? "添加成功" : "添加失败");

        //6、关闭
        pst.close();
        conn.close();

    }
}

```
## 获取自增长键值
- 在使用PreparedStatement添加数据时，获取自增长的键值
- 例如：购物时，在结算时，会产生新订单，返回新的订单，而一般的订单编号都是自增长或随机生成的，保证这个订单号的唯一
1. 如何让PreparedStatement执行完insert的sql后，带回增长的键值
- Statement.RETURN_GENERAL_KEYS
- 在创建这个PreparedStatement对象时，就要知名需要返回自增长的键值，否则mysql服务器不会返回
- 代码演示：
```java
import java.sql.*;

public class GetAutoIncriseValue {
    public static void main(String[] args) throws  Exception{
        //添加一个学生，返回id
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
        String sql = "insert into stu values(default,?,?,null)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,"谭咏麟");
        ps.setString(2,"男");
        int len = ps.executeUpdate();
        System.out.println(len>0?"添加成功":"添加失败");
        ResultSet rs = ps.getGeneratedKeys();//把自增长的键值返回
        if(rs.next()){
            System.out.println("新学生学号："+rs.getObject(1));
        }
        rs.close();
        ps.close();
        conn.close();
    }
}

```
## 批处理
1. 当要处理某一条sql语句多次
- 例如：当用户购买了东西后，一个订单中有很多的商品，那么就会涉及到
  - 在订单明细表中意味着要批量插入多条记录
  - 批量修改商品销量和存量
2. 如何实现批处理
- 执行时不能直接调用ps.executeUpdate()
- 需要做：
  - 执行addBatch()本质上是一个缓冲区
  - 然后执行executeBatch()
  - 返回值是一个int数组
  - mysql服务器默认是关闭批处理的，所以需要通过参数打开
  - 在url加一个rewriteBatchedStatements = true
  - 例如：jdbc:mysql://localhost:3306/java_sql_stu?rewriteBatchedStatements = true
  - 如果有多个参数，用&符号连接
- 代码演示
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchProcessing {
    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_sql_stu?rewriteBatchedStatements = true";
        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
        String sql = "insert into stu values(default,?,default,null)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 1000; i++) {
            ps.setString(1,"测试数据"+i);
            ps.addBatch();
        }
        ps.executeBatch();
    }
}

```
> 注：必须使用values，不要使用value
## jdbc的事务
1. 如何处理事务
- 在获取完连接后，在使用这个连接来创建PreparedStatement对象之前，要设置当前连接为手动提交事务
- conn.setAutoCommit(false)
- 在执行成功时，应该提交conn.commit() 
- 在执行失败时，应该回滚conn.rollback()
- 在关闭连接之前，把手动提交模式修改重新修改为自动提交模式
因为你后面获取的连接基本上是从数据库连接池中获取的连接，这种连接是“重复”使用的，那么如果你把它修改为“手动”提交了，
然后没有“还原”，当你把这个连接还给连接池时，这个连接可能会被其他人拿到，而他以为是自动提交的，然后操作完它的sql后，没有commit，结果是没有生效。
conn.setAutoCommit(true);
2. 需求
- 删除某个订单表的记录
- 删除订单明细表的记录
- 如果在订单明细表建立外键时，指定on delete cascade，那么在删除订单时，会自动把对应的订单明细表的记录删除
- 如果没有建立外键，那么在删除订单时，不会自动删除对应的订单明细的记录，那么就需要程序员，在编写对应sql去删除订单明细
## 数据库连接池
1. 数据库的连接相当于TCP/IP的Socket，每一次连接都有一个独立的Socket，每一次链接和释放都是一次高成本的操作
2. 假如：
- （1）如果我们每次为了执行sql时，都是问数据库服务器要新的连接，用完之后直接释放掉，那么成本很高。
- （2）如果每一个客户端每次为了执行sql时，都是问数据库服务器要新的连接，如果同时在线人数很多，并发操作很多时，
会导致数据库服务器的压力很大。因为对于服务器来说，每一个连接都有一个Socket，都有一个线程，数据库服务器很可能挂了。
3.  如何解决这个问题？
-   可以设计一个数据库连接池。 这个数据库连接池先提前准备好一些连接，那么等用户需要用到连接时，不用创建新的，从这个池中直接拿一个现成的。
当用户用完后，放回池中，给下一个人继续使用。
4.  这个数据库连接池有几个参数：
（1）初始化连接数：即一开始准备的连接数量，例如：10个
（2）最大连接数：即数据库服务器最多能承受多少个，例如：100个
（3）每次增量：如果10个不够了，会增加多少，直到达到100个
（4）等待时间：
- 如果到达100个，怎么办？
①让用户无限制等待
②等待xx时间后，返回异常，告知客户端，连接超时。
5. 一个项目，连接池创建一个，但是池中的连接可以很多个。 数据库连接池又称为数据源。DataSource
- 市面上有很多数据库连接池技术：
（1）DBCP ：Apache提供的数据库连接池，速度相对c3p0较快，但是有一些BUG
（2）c3p0 ：是一个开源组织提供的一个数据库连接池，速度相对较慢，稳定性还可以
（3）Proxool ：是sourceforge下的一个开源项目数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
（4）BoneCP ：一个开源组织提供的数据库连接池，速度快
（5）Druid（德鲁伊） :是阿里提供的数据库连接池，据说是集DBCP 、C3P0 、Proxool 优点于一身的数据库连接池，但是速度不知道是否有BoneCP快
6. 目的：
（1）连接资源重用
（2）对于用户来说，系统的响应速度更快
（3）新的资源分配手段
   - 原来是从数据库服务器直接获取连接
   - 现在是从连接池中拿连接
（4）避免数据库服务器挂掉
7.  如何使用Druid（德鲁伊）数据库连接池？
- 步骤：
（1）引入jar
- 放到libs中，并且添加到build path中
（2）创建连接池对象对象
- 方式一
（1）手动创建数据库连接池对象，在代码中硬编码配置参数
- 方式二：
（1）在配置文件中写配置参数
（2）在代码中用配置文件创建连接池对象对象
8. 参数：  参数名是固定，必备参数
- url：和原来一样
- username：用户名
- password：密码
- driverClassName；驱动类名
- initialSize：初始化连接数
- maxActive：最大连接数
- maxWait：当池中的连接都被占用了，新用户的等待时间，如果超过时间，就异常返回
- 可选参数：
  - maxIdle：
  - minIdle：	得保证池中释放掉一些连接后，最少需要保留几个，以备不时之需
（3）获取连接对象
- 数据库连接池对象.getConnection()获取到连接后，增删改查不变
（4）用完后，close()还回去
- 有了数据库连接池，无非改变的是获取连接的方式而已。其他的不变。

