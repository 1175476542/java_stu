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