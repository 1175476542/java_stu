import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class TestConnectionPool {
    @Test
    public void test01() throws Exception{
        Properties pro = new Properties();//特点：key和value都是String

        //硬编码
        pro.setProperty("url", "jdbc:mysql://localhost:3306/test");
        pro.setProperty("username", "root");
        pro.setProperty("password", "1234");

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        System.out.println(ds.getClass());//com.alibaba.druid.pool.DruidDataSource
    }
    @Test
    public void test03()throws Exception{
        Properties pro = new Properties();
        //TestPools.class：得到当前类的Class对象
        //xx.getClassLoader()：获取类加载器对象
        //类加载器对象.getResourceAsStream()：加载资源文件，并且把配置文件中的数据封装到Properties对象
        //这个资源文件格式：key=value
        pro.load(TestConnectionPool.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //从数据库连接池中拿连接
        for (int i = 1; i <=30; i++) {
            Connection conn = ds.getConnection();
            System.out.println("第" + i +"个连接：" + conn);

            conn.close();//还给它了
        }
    }
    @Test
    public void test04()throws Exception{
        Properties pro = new Properties();
        //TestPools.class：得到当前类的Class对象
        //xx.getClassLoader()：获取类加载器对象
        //类加载器对象.getResourceAsStream()：加载资源文件，并且把配置文件中的数据封装到Properties对象
        //这个资源文件格式：key=value
        pro.load(TestConnectionPool.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //从数据库连接池中拿连接
        for (int i = 1; i <=30; i++) {
            new Thread(i+""){
                public void run(){
                    try {
                        Connection conn = ds.getConnection();
                        System.out.println("第" + getName() +"个连接：" + conn);

                        Thread.sleep(500);

                        conn.close();//还给它了
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }.start();
        }

        Thread.sleep(100000);
    }
}
