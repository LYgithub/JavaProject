package com.yang.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: com.yang.aop
 * Created by MacBook Air on 2020/09/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Component("myLogger")
public class MyLogger {

    private Logger logger = Logger.getLogger(MyLogger.class);

    public void BeforeMethod(JoinPoint joinPoint){
        //
        String name = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();

        logger.info(">> BeforeMethod >>>" + name + ":" + target + ":" + Arrays.toString(args));
    }

    public void AfterMethod(JoinPoint joinPoint){
        logger.info(">> AfterMethod >>>" + joinPoint.getSignature().getName() );
    }

    public void AfterThrowing(JoinPoint joinPoint, Exception e){
        logger.info(">> AfterThrowing >>>" + joinPoint.getSignature().getName() + ":Error Message:" + e.getMessage()) ;
    }

    public void AfterReturning(JoinPoint joinPoint, Object value_return){
        logger.info(">> AfterReturning >>>" + joinPoint.getSignature().getName() + ":Return Value:" + value_return.toString() );
    }
}
