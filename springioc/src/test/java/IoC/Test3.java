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
public class Test3 {
    public static void main(String[] args) {
        try{

            ApplicationContext context = new ClassPathXmlApplicationContext("iocconfig.xml");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
