package com.kawyang.test;

import com.kawyang.bean.Department;
import com.kawyang.bean.Employee;
import com.kawyang.dao.DepartmentMapper;
import com.kawyang.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RunAs;
import java.util.UUID;

/**
 * @author LiYang
 * 1、导入SpringTest 模块
 * 2、ContextConfiguration指定 Spring 配置文件
 * 3、直接@Autowrited 自动获取
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JDBCTest_Spring {


    @Autowired
    DepartmentMapper departmentMapper;
    
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test1() {
        // 插入一个部门
        departmentMapper.insert(new Department(null,"算法部门"));

    }

    @Test
    public void test2() {
        //employeeMapper.insert(new Employee(null, "李四", "W","12321@qq.com",2,null));
        // 批量插入
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 100; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insert(new Employee(null,uid, i%2==0?"M":"W",uid+"@163.com",i%4+1,null));
        }

    }

}
