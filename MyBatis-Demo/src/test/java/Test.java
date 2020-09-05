
import com.yang.dao.StudentDao;
import com.yang.entity.Student;
import com.yang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService bean = context.getBean(StudentService.class);
        System.out.println(bean.findById(1).toString());
        System.out.println(Arrays.toString(bean.findAll().toArray()));
    }
}
