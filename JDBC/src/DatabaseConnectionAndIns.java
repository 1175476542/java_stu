import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionAndIns {
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
