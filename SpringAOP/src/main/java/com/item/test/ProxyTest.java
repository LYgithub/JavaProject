package com.item.test;

import com.item.util.Cal;
import com.item.util.MyInvocationHandler;
import com.item.util.impl.CalImpl;

/**
 * @author LiYang
 * @Project Name: SpringAOP
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ProxyTest {
    public static void main(String[] args) {
        CalImpl cal = new CalImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        Cal bind = (Cal)invocationHandler.bind(cal);

        bind.add(1,2);

        bind.sub(1,2);
        bind.mul(2,3);
        bind.div(4,2);
    }
}
