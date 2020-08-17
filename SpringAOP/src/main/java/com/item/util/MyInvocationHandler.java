package com.item.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: SpringAOP
 * @Package Name: com.item.util
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 创建一个委托对象
     */
    private Object object = null;

    /**
     * 返回代理对象
     * @param object
     * @return
     */
    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(method.getName() + "方法：" + Arrays.toString(args));
        Object result = method.invoke(this.object, args);
        System.out.println("结果：" + result);
        return result;
    }
}
