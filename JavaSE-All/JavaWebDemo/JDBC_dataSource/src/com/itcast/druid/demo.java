package com.itcast.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: com.itcast.druid
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class demo {
    public static void main(String[] args) throws Exception {

        //加载配置文件
        Properties pro = new Properties();
        InputStream resourceAsStream = demo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(resourceAsStream);

        //获取连接池对象 ： 通过工厂来获取
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection con = ds.getConnection();
        System.out.println(con);

    }

}
