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
        st.close();
        conn.close();
    }
}
