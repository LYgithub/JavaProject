package com.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author LiYang
 * @Project Name: HomeWork
 * @Package Name: com.util
 * Created by MacBook Air on 2020/06/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class JDBCutil {
    private static String url,user,password;
    static {
        URL resource = JDBCutil.class.getClassLoader().getResource("pro.properties");
        assert resource != null;
        String path = resource.getFile();
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(path));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static boolean loginCheck(String username, String password){
        Connection con = null;
        PreparedStatement sta = null;
        String sql = "select * from user where userName=? and passWord=?";
        try{
            con = getConnection();
            sta = con.prepareStatement(sql);
            sta.setString(1, username);
            sta.setString(2, password);
            ResultSet resultSet = sta.executeQuery();
            return resultSet.next();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
