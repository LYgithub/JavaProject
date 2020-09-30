package IoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/20.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 *
 * p 命名空间测试
 */

public class Test4 {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("iocconfig.xml");
            Object student_p = context.getBean("student_p");
            System.out.println(student_p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
