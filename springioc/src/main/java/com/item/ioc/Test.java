package com.item.ioc;

import org.dom4j.DocumentException;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item.ioc
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("iocconfig.xml");
        System.out.println(context.getBean("student"));
    }
}
