package com.yang;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: com.yang
 * Created by MacBook Air on 2020/08/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FBI implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Man man = ((Man) o);
        System.err.println("FBI发现:" + man.getName() +"，动作：" +method.getName());
    }
}
