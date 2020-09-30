package com.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: com.itcast.jdbc
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception{

        //1. 导入Jar包
        //2. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //3 获取链接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "liyangLY");
        String sql = "update student set score='0.01' where " +
                "age=1";

        // 获取执行sql对象
        Statement statement = connection.createStatement();
        // 执行sql
        int i = statement.executeUpdate(sql);
        // 处理结果
        System.out.println(i);
        // 释放资源
        statement.close();
        connection.close();


    }
}
