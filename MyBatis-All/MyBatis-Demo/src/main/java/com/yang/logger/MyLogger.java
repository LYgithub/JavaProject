package com.yang.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: com.yang.logger
 * Created by MacBook Air on 2020/09/05.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Aspect
@Component
public class MyLogger {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * 切入事务测试方法
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.yang.service.StudentService.login(..))")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Exception {
        logger.info("\n---------------------------- update start----------------------------------");
        try {
            Object proceed = joinPoint.proceed();
            logger.info("\n-------------------------> " + proceed.toString());
        } catch (Throwable throwable) {
            logger.error("\n-------------------------> " + throwable.getMessage());
            throw new Exception("Error : not finished!");
        }
        logger.info("\n---------------------------- update end----------------------------------");
    }
}
