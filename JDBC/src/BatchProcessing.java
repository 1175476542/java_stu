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
