package com.itcast.jdbcSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: com.itcast.jdbcSource
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws Exception{
        // 1. 创建数据库连接池
        DataSource ds = new ComboPooledDataSource( );
        // 2. 获取连接对象
        Connection con = ds.getConnection();
        // 3. 打印
        System.out.println(con);
        con.close();
    }
}
