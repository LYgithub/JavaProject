package com.kawyang.controller;

import com.kawyang.bean.Department;
import com.kawyang.bean.Msg;
import com.kawyang.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LiYang
 * 处理部门信息请求
 */

@Controller
public class DepartmentController {

    //部门有关的业务逻辑组建
    @SuppressWarnings("all")
    @Autowired
    private DepartmentService departmentService;


    @ResponseBody
    @RequestMapping("/depts")
    public Msg getDepts(){
        List<Department> depts = departmentService.getDepts();

        return Msg.success().add("depts", depts);
    }
}
