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
        System.out.println("interFace : "+ object.getClass().getInterfaces());
        return Proxy.newProxyInstance(
                // 加载代理对象的类加载器
                object.getClass().getClassLoader(),
                // 动态代理需要实现的接口
                object.getClass().getInterfaces(),
                //动态代理方法在执行时需要回调类里的 invoke 方法
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(method.getName() + "方法：" + Arrays.toString(args));
        Object result = method.invoke(this.object, args);
        System.out.println("结果：" + result);
        return result;
    }
}
