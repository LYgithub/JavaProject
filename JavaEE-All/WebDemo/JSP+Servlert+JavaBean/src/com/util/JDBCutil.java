package com.util;

import org.junit.Test;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.util
 * Created by MacBook Air on 2020/06/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class JDBCutil {
    private static String user, password, url, dbname;

    static {
        URL resource = JDBCutil.class.getClassLoader().getResource("pro.properties");
        String file = resource.getFile();
        Properties pro = new Properties();
        try{
            pro.load(new FileReader(file));
            url = pro.getProperty("jdbcurl");
            user = pro.getProperty("user");
            dbname =pro.getProperty("dbname");
            password = pro.getProperty("password");
            //注册
            Class.forName(pro.getProperty("driver"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean selectLogin(String userName_, String password_){
        String sql = "select * from " + dbname +" where userName=? and passWord=?";
        Connection con;
        PreparedStatement statement;
        try{
            con = DriverManager.getConnection(url, user, JDBCutil.password);
            statement = con.prepareStatement(sql);
            statement.setString(1, userName_);

            statement.setString(2, password_);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(JDBCutil.selectLogin("liyang", "123"));
    }


}