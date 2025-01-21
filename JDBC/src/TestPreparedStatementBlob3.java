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
