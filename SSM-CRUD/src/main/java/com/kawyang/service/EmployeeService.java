package com.kawyang.service;

import com.kawyang.bean.Employee;
import com.kawyang.bean.EmployeeExample;
import com.kawyang.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: SSM-CRUD
 * @Package Name: com.kawyang.service
 * Created by MacBook Air on 2020/07/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> findAll(Employee employee) {
        return employeeMapper.selectByExampleWithDepartment(null);
    }

    public int saveEmp(Employee employee) {
        return employeeMapper.insert(employee);
    }

    /**
     * 检测用户名是否可用
     *
     * @param empName
     * @return
     */
    public boolean checkUser(String empName) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.countByExample(employeeExample) == 0;
    }

    public Employee findbyId(int id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    public int update(Employee employee) {
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        return i;
    }

    public int deleteEmp(int id) {
        int i = employeeMapper.deleteByPrimaryKey(id);
        return i;
    }

    public int deleteBantch(List<Integer> split) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(split);
        employeeMapper.deleteByExample(employeeExample);
        return 0;
    }
}
