package com.yang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LiYang
 * @Project Name: Java-SE
 * @Package Name: com.yang.proxy
 * Created by MacBook Air on 2020/09/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ProxyHandler implements InvocationHandler {

    // 被代理的对象
    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----");
        method.invoke(object, args);
        System.out.println("----");
        return this;
    }
}
