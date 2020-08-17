package utils;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: utils
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public class JDBCtools {
    private static String user,password,url;
    /**
     * 只读取一次文件获取信息
     */
    static {
        //获取src文件 --> ClassLoader
        URL resource = JDBCtools.class.getClassLoader().getResource("pro.properties");
        String file = resource.getFile();

        Properties pro = new Properties();

        try {
            pro.load(new FileReader(file));
            url = pro.getProperty("jdbcurl");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            Class.forName(pro.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 防止SQL注入
     * @param sql
     * @param age
     * @param score
     * @return
     */
    public static boolean selectPro(String sql, String age, String score){
        Connection con = null;
        PreparedStatement stam = null;
        int i = 0;
        try {

            con = getConnection();

            stam = con.prepareStatement(sql);
            // 给 ? 赋值
            stam.setString(1, age);
            stam.setString(2, score);

            ResultSet resultSet = stam.executeQuery();
//            if(resultSet.next()){
//                return true;
//            }else{
//                return false;
//            }
            return resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            close(con, stam);
        }
    }

    public static boolean select(String sql){
        Connection con = null;
        Statement stam = null;
        int i = 0;
        try {
            con = getConnection();
            stam = con.createStatement();
            ResultSet resultSet = stam.executeQuery(sql);
//            if(resultSet.next()){
//                return true;
//            }else{
//                return false;
//            }
            return resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            close(con, stam);
        }
    }

    public static int insert(String sql){
        Connection con = null;
        Statement stam = null;
        int i = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            stam = con.createStatement();
            i = stam.executeUpdate(sql);
            con.commit();
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            close(con, stam);
            return i;
        }
    }
    public static void close(Connection con, Statement stm, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(con, stm);

    }

    public static void close(Connection con, Statement stm) {
        if(stm != null){
            try {
                stm.close();
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

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return con;
    }
}
