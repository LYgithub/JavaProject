package com.kawyang.test;


import com.kawyang.bean.Department;
import com.kawyang.dao.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: SSM-CRUD
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/07/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class JDBCTest {
    @Test
    public void testCRUD() {
        //1、创建IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapper bean = context.getBean(DepartmentMapper.class);
        Department x = bean.selectByPrimaryKey(1);
        System.out.println(x.toString());
    }
}
