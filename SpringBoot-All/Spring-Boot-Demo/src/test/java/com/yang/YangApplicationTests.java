package com.yang;

import com.yang.dao.StudentDao;
import com.yang.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YangApplicationTests {

    //@Autowired
    //StudentDao studentDao;


    /// 获取配置文件中的数据
    @Value("${spring.datasource.url}")
    String url;

    /// 自动注入
    @Autowired
    Student student;

    @Test
    void contextLoads() {
        //System.out.println(studentDao.findById(1));
        System.out.println(url);
        System.out.println(student.toString());
    }

}
