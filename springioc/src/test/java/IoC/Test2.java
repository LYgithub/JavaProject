package IoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocconfig.xml");
            Object classes = applicationContext.getBean("classes");
            System.out.println(classes);

            Object classes2 = applicationContext.getBean("classes");
            System.out.println(classes == classes2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
