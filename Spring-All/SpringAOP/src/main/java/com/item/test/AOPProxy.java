package com.item.test;

import com.item.util.Cal;
import com.item.util.impl.CalImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: SpringAOP
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class AOPProxy {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-config.xml");

        Cal test = (Cal)applicationContext.getBean("test");
        System.out.println(test.getClass().getName());
        System.out.println(test.add(1,2));
        System.out.println(test.div(2,0));
    }
}
