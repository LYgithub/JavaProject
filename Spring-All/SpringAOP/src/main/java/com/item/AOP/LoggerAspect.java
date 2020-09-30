package com.item.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: SpringAOP
 * @Package Name: com.item.AOP
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */

//切面对象
@Aspect
//IoC管理 相当于配置 xml
@Component
public class LoggerAspect {
    @Before("execution(public int com.item.util.impl.CalImpl2.*(..))")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println(name + "方法：" + Arrays.toString(args));
    }


    @After("execution(public int com.item.util.impl.CalImpl2.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println(Arrays.toString( joinPoint.getClass().getMethods()));
        System.out.println("结束！！");
    }

    @AfterReturning(returning = "result", value = "execution(public int com.item.util.impl.CalImpl2.*(..))")
    public void afterReturn(JoinPoint joinPoint, Object result){
        System.out.println(Arrays.toString( joinPoint.getClass().getMethods()));
        System.out.println("返回结果：" + result);
    }

    /**
     * 抛出异常处理方法
     * @param joinPoint
     * @param result
     */
    @AfterThrowing(throwing = "result",
            value = "execution(public int com.item.util.impl.CalImpl2.div(..))")
    public void throwing(JoinPoint joinPoint, Exception result){
        int a;
    }
}


