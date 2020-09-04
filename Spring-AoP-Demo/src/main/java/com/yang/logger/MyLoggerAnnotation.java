package com.yang.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: com.yang.logger
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Aspect
@Component
public class MyLoggerAnnotation {
    private Logger logger = Logger.getLogger(MyLoggerAnnotation.class);

    private final String exec = "execution(* com.yang.test.Demo3.method(..))";

    @Around(exec)
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        logger.info(">>> Around >> 切面前");
        try{
            Object proceed = joinPoint.proceed();
            if(proceed != null) {
                System.out.println(proceed.toString());
            }
        }catch (Throwable e){
            logger.info(">>> Around >>  Error :" + e.getMessage());
        }
        logger.info(">>> Around >> 切面后");
        return null;
    }

    @After(exec)
    public void afterMethod(JoinPoint joinPoint){
        logger.info(">>> After >>" + joinPoint.getSignature().getName());
    }

    @Before(exec)
    public void beforeMethod(JoinPoint joinPoint){
        logger.info(">>> Before >>" + joinPoint.getArgs().toString());
    }


    @AfterThrowing(value = exec, throwing = "e")
    public void afterMethod(JoinPoint joinPoint, Exception e){
        logger.error(">>> Error >>" + joinPoint.getSignature().getName()+"; ErrorMessage:"+e.getMessage());
    }

    @AfterReturning(value = "execution(* com.yang.test.Demo3.method2(..))", returning = "o")
    public void returnMethod(JoinPoint joinPoint, Object o){
        logger.info(">>> Return" + joinPoint.getTarget() + "; Return :" + o.toString());
    }
}
