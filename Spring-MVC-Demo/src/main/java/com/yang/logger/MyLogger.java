package com.yang.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: Spring-MVC-Demo
 * @Package Name: com.yang.logger
 * Created by MacBook Air on 2020/08/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Component("log")
public class MyLogger {
    private Logger logger = Logger.getLogger(MyLogger.class);

    ///@Test
    //public void test(){
    //    logger.info("日志信息...info");
    //    logger.debug("日志信息...debug");
    //    logger.warn("日志信息...warn");
    //    logger.error("日志信息...error");
    //}

    /**
     * 方法执行结束后执行
     */
    public void AfterLog(JoinPoint joinpoint){
        // 通过设置参数获取 切点参数
        Object target = joinpoint.getTarget();
        String name = joinpoint.getSignature().getName();
        Object[] args = joinpoint.getArgs();
        String s = Arrays.toString(args);
        logger.info(target + ">>>" + name + "方法被调用，参数为：" + s);

    }
}
