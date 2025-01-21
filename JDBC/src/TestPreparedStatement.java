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
