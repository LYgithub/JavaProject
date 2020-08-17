package com.kawyang.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: com.kawyang.utils
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MapperUtil {
    public static <T> T getMapper(String config, Class<T> tClass){
        // 1. 读取配置文件
        InputStream resourceAsStream = MapperUtil.class.getClassLoader().getResourceAsStream(config);
        // 2. 获取 SqlSession 对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = builder.build(resourceAsStream).openSession();
        // 3. 返回 Mapper 对象
        return sqlSession.getMapper(tClass);
    }
}
