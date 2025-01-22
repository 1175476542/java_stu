import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCTransaction {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_sql_stu";
        Connection conn = DriverManager.getConnection(url,"root","Sirius@0615..");
        String sql = "delete from orders where id = ?";
        //设置手动提交事务
        conn.setAutoCommit(false);

        //3、编写sql
        //删除订单表
        String sql1 = "DELETE FROM orders WHERE id = ?";
        String sql2 = "DELETE FROM order_items where order_id = ?";//故意把这条sql写错，使得sql2执行失败，这里故意省略where

        //4，创建PreparedStatement
        PreparedStatement pst1 = conn.prepareStatement(sql1);
        pst1.setObject(1, "15275760194821");

        PreparedStatement pst2 = conn.prepareStatement(sql2);
        pst2.setObject(1, "15275760194821");

        //5、执行sql
        boolean flag = true;//假设成功
        try {
            int len1 = pst1.executeUpdate();

            if(!(len1 > 0)){
                flag = false;
            }

            if(flag){
                int len2 = pst2.executeUpdate();
                if(!(len2>0) ){
                    flag = false;
                }
            }

            if(flag){
                System.out.println("成功了");
                conn.commit();
            }else{
                System.out.println("失败了");
                conn.rollback();
            }
        } catch (Exception e) {
            System.out.println("异常了");
            conn.rollback();
        }


        //6、关闭
        pst1.close();
        pst2.close();
        conn.setAutoCommit(true);//好的习惯
        conn.close();
    }
}
