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
