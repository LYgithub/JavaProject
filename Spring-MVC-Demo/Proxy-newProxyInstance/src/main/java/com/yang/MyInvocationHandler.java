package com.yang;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LiYang
 * @Project Name: Proxy-newProxyInstance
 * @Package Name: com.yang
 * Created by MacBook Air on 2020/08/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
public class MyInvocationHandler implements InvocationHandler {
    /** 委托对象 */
    private Object object = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- start -----");
        Object invoke = method.invoke(object, args);
        System.out.println("----- end -----");
        return invoke;
    }
}
