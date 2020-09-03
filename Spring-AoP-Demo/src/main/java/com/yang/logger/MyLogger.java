package com.yang.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    public void beforeMethod(JoinPoint joinPoint){
        //
        String name = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        logger.info(">> BeforeMethod >>>" + name + ":" + target + ":" + Arrays.toString(args));
    }

    public void afterMethod(JoinPoint joinPoint){
        logger.info(">> AfterMethod >>>" + joinPoint.getSignature().getName() );
    }

    public void afterThrowing(JoinPoint joinPoint, Exception e){
        logger.info(">> AfterThrowing >>>" + joinPoint.getSignature().getName() + ":Error Message:" + e.getMessage()) ;
    }

    public void afterReturning(JoinPoint joinPoint, Object value_return){
        logger.info(">> afterReturning >>>" + joinPoint.getSignature().getName() + ":Return Value:" + value_return.toString() );
    }


    /**
     * ProceedingJoinPoint extends JoinPoint
     * @param joinPoint
     */
    public void aroundMethod(ProceedingJoinPoint joinPoint){
        // 前置增强方法
        Object object = null;
        logger.info("增强前");
        try {
            // 类似拦截器 放行后执行方法， 并将方法的返回值作为 proceed 方法的返回值(后置增强)
            object = joinPoint.proceed();

        } catch (Throwable e) {
            // 抛出的异常作为 切入方法所抛出的异常(异常抛出增强)
            logger.info("Error:"+ e.getMessage());
        }

        // 最终增强
        logger.info("增强后:" + object);
    }
}
