package ioc;

import com.kawyang.model.Classes;
import com.kawyang.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: SpringIoCTest
 * @Package Name: ioc
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc-config.xml");
        Classes classes =(Classes) context.getBean("classes");
        System.out.println(classes.toString());

        Student student = (Student) context.getBean("student2");
        System.out.println(student);

    }

}
