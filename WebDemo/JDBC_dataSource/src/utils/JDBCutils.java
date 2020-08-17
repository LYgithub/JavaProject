package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LiYang
 * 连接池的工具类
 */
public class JDBCutils {
    private static DataSource ds;
    static{
        Properties pro = new Properties();
        try {
            pro.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    public static Connection getConn() throws Exception{
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param stam
     * @param con
     */
    public static void close(PreparedStatement stam , Connection con){
        if(stam != null){
            try {
                stam.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
