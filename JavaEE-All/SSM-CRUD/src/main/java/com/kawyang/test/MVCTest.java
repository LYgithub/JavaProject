package com.kawyang.test;

import com.github.pagehelper.PageInfo;
import com.kawyang.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author LiYang
 * 使用Spring 测试模块完成  请求测试
 * 需要servlet 3.0
 */

@SuppressWarnings("all")
//注入 IoC容器
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/springDispatcherServlet-servlet.xml"})
public class MVCTest {

    //传入Spring MVC 的 IoC
    @Autowired
    WebApplicationContext webApplicationContext;
    //虚拟mvc请求，获取请求结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testMVC() {
        try {
            MvcResult page = mockMvc.perform(MockMvcRequestBuilders.get("/emps")
                    .param("page", "13")).andReturn();

            PageInfo pageInfo = ((PageInfo) page.getRequest().getAttribute("pageInfo"));
            System.out.println("当前页码：" + pageInfo.getPageNum());
            System.out.println("总页码：" + pageInfo.getPages());
            System.out.println("总记录数" + pageInfo.getTotal());
            System.out.println("显示的页码数：");
            int[] navigatepageNums = pageInfo.getNavigatepageNums();
            for (Integer i : navigatepageNums) {
                System.out.println(i);
            }

            List<Employee> list = pageInfo.getList();
            for (Employee employee:
                 list) {
                System.out.println(employee.getdId() + ":" + employee.getEmpName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
