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
