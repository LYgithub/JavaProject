package IoC;

import com.item.Student;
import org.junit.internal.Classes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test1 {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocconfig.xml");
        Object classes3 = applicationContext.getBean("classes3");
        Object classes4 = applicationContext.getBean("classes");

        System.out.println(classes3 == classes4);

        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean);
    }
}
