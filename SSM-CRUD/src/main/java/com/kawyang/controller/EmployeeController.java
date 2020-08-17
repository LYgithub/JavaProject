package com.kawyang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kawyang.bean.Employee;
import com.kawyang.bean.Msg;
import com.kawyang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;

/**
 * @author LiYang
 * @Project Name: SSM-CRUD
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/07/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/emps")
    public String findAll(@RequestParam(value = "page",defaultValue = "1")Integer page, Model model){
        //注册
        //开始的页数
        PageHelper.startPage(page,5);
        List <Employee> list = employeeService.findAll(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(list,5);
        model.addAttribute("pageInfo",pageInfo);
        //
        //model.addAttribute("list",list);
        return "emps";
    }

    @RequestMapping("/emps-json")
    @ResponseBody
    public PageInfo getPageInfo(@RequestParam(value = "page",defaultValue = "1")Integer page){
        //注册
        //开始的页数
        PageHelper.startPage(page,5);
        List <Employee> list = employeeService.findAll(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(list,5);
        return pageInfo;
    }

    @RequestMapping(value = "/emps-msg",method = RequestMethod.GET)
    @ResponseBody
    public Msg getPageInfoUseMsg(@RequestParam(value = "page",defaultValue = "1")Integer page){
        //注册
        //开始的页数
        PageHelper.startPage(page,5);
        List <Employee> list = employeeService.findAll(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(list,5);

        return Msg.success().add("pageInfo",pageInfo);
    }


    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg emp_add (@Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,Object> map = new HashMap<>();
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError error: allErrors) {
                System.out.println(error.getField() + "======>" + error.getDefaultMessage());
                map.put(error.getField(),error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }else {
            int i = employeeService.saveEmp(employee);
            return Msg.success().add("something", i);
        }
    }

    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkuser(String empName){
        //判断是否是 合法数据
        ///^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
        String rex = "(^[a-z0-9A-Z_-]{6,15}$)|(^[\u4e00-\u9fa5]{2,5})";
        boolean matches = empName.matches(rex);
        System.out.println(matches);
        if(!matches){
            return Msg.fail().add("va_msg","用户名英文6-15位或者3-5位中文");
        }
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else {
            return Msg.fail().add("va_msg","用户名已存在！");
        }
    }

    @RequestMapping("/empbyid/{id}")
    @ResponseBody
    public Msg getEmpById(@PathVariable int id){
        Employee employee = employeeService.findbyId(id);
        if(employee != null){
            return Msg.success().add("emp",employee);
        }else{
            return Msg.fail();
        }
    }

    //https://blog.csdn.net/Prinz_Corn/article/details/81837542

    @RequestMapping(value = "/emp-update/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(Employee employee){
        //System.out.println("============>" + employee.toString());
        try{
            int update = employeeService.update(employee);
            return Msg.success();
        }catch(Exception e){
            e.printStackTrace();
            return Msg.fail();
        }
    }


    //@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    //@ResponseBody
    //public Msg deleteEmpById(@PathVariable int id){
    //    int x = employeeService.deleteEmp(id);
    //    return Msg.success();
    //}

    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmpById(@PathVariable("ids") String ids){

        String[] split = ids.split("-");
        List<Integer> list = new ArrayList<>();
        for (String s: split) {
            list.add(Integer.parseInt(s));
        }
        int x = employeeService.deleteBantch(list);
        return Msg.success();
    }
}
