package com.kawyang.service;

import com.kawyang.bean.Department;
import com.kawyang.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: SSM-CRUD
 * @Package Name: com.kawyang.service
 * Created by MacBook Air on 2020/07/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
