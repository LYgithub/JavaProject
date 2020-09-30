package com.company.反射.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.反射.动态代理
 * Created by MacBook Air on 2020/05/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public static void main(String[] args) {
        ITestDemo test = new TestDemoImp1();
        test.test1();
        test.test2();
        /**
         * 在执行test1 和 test2 方法时需要加入
         * test1 运行... test1 结束...
         * 如果想被Proxy代理， 必须有相应的接口
         */

        //1 创建代理对象
        InvocationHandler handler = new ProxyDemo(test);
        /**
         * public static Object newProxyInstance(
         *                                           ClassLoader loader, 代理对象的类加载器
         *                                           Class<?>[] interfaces, 代理对象的接口
         *                                           InvocationHandler h)  代理对象
         *                                           返回值成功被代理后的对象
         */
        ITestDemo testDemo =(ITestDemo) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                test.getClass().getInterfaces(), handler);
        testDemo.test2();
        testDemo.test1();
    }
}

/**
 * 创建代理类
 * 实现invocationHandler
 */
class ProxyDemo implements InvocationHandler{
    //被代理对象
    Object obj;

    public ProxyDemo(Object obj) {
        this.obj = obj;
    }

    /**
     * @param proxy
     * @param method 代理对象的指定方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.println(method.getName() + "开始运行！");
        //执行代理的制定方法
        Object x = method.invoke(this.obj, args);

        System.out.println(method.getName() + "运行结束！");
        return x;
    }
}
