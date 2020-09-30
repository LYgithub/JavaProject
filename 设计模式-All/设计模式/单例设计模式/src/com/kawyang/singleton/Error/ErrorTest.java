package com.kawyang.singleton.Error;

import com.kawyang.singleton.lazysingleton.LazySingleton3;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.singleton.Error
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ErrorTest {
    /**
     * 使用反射创建对象
     */
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<LazySingleton3> declaredConstructor = LazySingleton3.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingleton3 lazySingleton3 = declaredConstructor.newInstance();
        Assert.assertEquals(false, lazySingleton3.getInstance() == LazySingleton3.getInstance());
    }

}
