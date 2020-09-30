package com.yang.proxy;

import java.lang.reflect.Proxy;

/**
 * @author LiYang
 * @Project Name: Java-SE
 * @Package Name: com.yang.proxy
 * Created by MacBook Air on 2020/09/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ProxyTest {
    public static void main(String[] args) {

        Hello object = new Hello();
        ProxyHandler proxyHandler = new ProxyHandler(object);
        /// 创建代理
        IHello hello = (IHello) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                proxyHandler);
        hello.print();
    }
}
