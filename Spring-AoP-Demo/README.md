## AoP

> 面向切面编程


### AoP 配置标签结构

```xml
<aop:config>
    <!-- 定义切点的位置 --> 
    <aop:pointcut  />
    <!-- 设置切面 -->
    <aop:aspect >
       <!-- 设置切点 --> 
       <aop:Before></aop:Before>
    </aop:aspect>
</aop:config>
```

### aop:aspect 子标签


> `Pointcut`标签 可以设置多个，但必须在`aspect`标签之前
>
> `Before .. `  标签必须指定  `pointcut-ref` 属性

#### Before

> Before 将方法执行之前作为切入点

#### After

> After 将方法结尾作为切入点

#### After-throwing

> After-throwing 将方法中出现异常之后作为切入点
> throwing 属性，设置抛出的异常信息`参数(Exception 类型)` ，在切入的方法中必须设置相应的参数(`如果含有JoinPoint参数，必须在此之后`)

#### After-returning

> After-returning 将方法的返回值之后作为切入点
> returning 属性，传递返回值内容(`Object 类型`)，切入的方法需要有相应的参数(`如果含有JoinPoint参数，必须在此之后`)

#### [Around](#环绕增强)

### 实例

[源码连接](https://github.com/LYgithub/JavaProject/tree/master/Spring-AoP-Demo)

#### AoP配置

```xml
    <aop:config>
        <!-- 设置多个切点 -->
        <aop:pointcut id="point" expression="execution(* com.yang..*.*(..))"/>
        <aop:pointcut id="point1" expression="execution(* com.yang.test.*.*(..))"/>
        <aop:aspect ref="myLogger">
            <aop:before method="BeforeMethod" pointcut-ref="point" />
            <aop:after method="AfterMethod" pointcut-ref="point" />
            <aop:after-throwing method="AfterThrowing" pointcut-ref="point" throwing="e"/>
            <aop:after-returning method="AfterReturning" pointcut-ref="point" returning="value_return" />

            <aop:after method="AfterMethod" pointcut-ref="point2" />
        </aop:aspect>
        <!-- 位置错误 -->
        <!--<aop:pointcut id="point1" expression="execution(* com.yang.test.*(..))"/> -->

        <aop:aspect ref="myLogger">
            <aop:before method="BeforeMethod" pointcut-ref="point1" />
            <aop:after method="AfterMethod" pointcut-ref="point1" />
            <aop:after-throwing method="AfterThrowing" pointcut-ref="point1" throwing="e"/>
            <aop:after-returning method="AfterReturning" pointcut-ref="point1" returning="value_return" />

            <aop:after method="AfterMethod" pointcut-ref="point1" />

        </aop:aspect>
    </aop:config>
```

#### Logger类

```java
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
        logger.info(">> afterReturning >>>" + joinPoint.getSignature().getName() + ":Return Value:" + value_return.toString() );
    }
}

```

#### 被切入类

```java
package com.yang.test;

import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: com.yang.test
 * Created by MacBook Air on 2020/09/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Component("demo")
public class Demo {
    public String method1(String arg1, int id){
        try {
            System.out.println("———————  Start method  ———————");
            int x = 1 / 0;
            System.out.println(x);
            return "Finish";
        }catch (Exception e){
            return "Error";
        }
        finally {
            System.out.println("———————  End method  ———————");
        }
    }
}
```

#### 测试

```java
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo = ((Demo) applicationContext.getBean("demo"));
        demo.method1("参数1",2);
    }
}
```

#### 运行结果

```sh
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> BeforeMethod >>>method1:com.yang.test.Demo@12359a82:[参数1, 2]
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> BeforeMethod >>>method1:com.yang.test.Demo@12359a82:[参数1, 2]
———————  Start method  ———————
———————  End method  ———————
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> AfterMethod >>>method1
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> AfterMethod >>>method1
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> AfterReturning >>>method1:Return Value:Error
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> AfterReturning >>>method1:Return Value:Error
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> AfterMethod >>>method1
09-03 14:52:45[INFO]com.yang.logger.MyLogger >> AfterMethod >>>method1
```

## 环绕增强

> 环绕增强可以完成以上所有的增强方法



```xml
<!-- 配置环绕增强 -->
<aop:config>
    <aop:pointcut id="point_around" expression="execution(* com.yang.test.Demo2.*(..))"/>
    <aop:aspect ref="myLogger">
        <aop:around method="aroundMethod" pointcut-ref="point_around" />
    </aop:aspect>
</aop:config>
```



```java
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
```

```java
@Component("demo")
public class Demo {
    public String method1(String arg1, int id){
        try {
            System.out.println("———————  Start method  ———————");
            int x = 1 / 0;
            System.out.println(x);
            return "Finish";
        }catch (Exception e){
            return "返回值:Error";
        }
        finally {
            System.out.println("———————  End method  ———————");
        }
    }
}
```

#### 运行过程如图所示

> 将 `Demo` 作为被切入对象

![image-20200903164416888](https://gitee.com/KawYang/image/raw/master/img/image-20200903164416888.png)

## 注解方式

> 测试文件 `src/test/Test2Annotation`

- 注解 xml 设置
```xml
<!-- 扫描 Bean   -->
<context:component-scan base-package="com.yang" />
<!--  使 Aspect 标签生效，为目标类自动生成代理对象  -->
<aop:aspectj-autoproxy />
```
- 切面对象设置

> 类前添加 `@Aspect`注解
> 切面注解 `@Around..`

```java
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
        logger.info("切面前");
        try{
            Object proceed = joinPoint.proceed();
            if(proceed != null) {
                System.out.println(proceed.toString());
            }
        }catch (Throwable e){
            logger.info(e.getMessage());
        }
        logger.info("切面后");
        return null;
    }

    @After(exec)
    public void afterMethod(JoinPoint joinPoint){
        logger.info(">>> After" + joinPoint.getSignature().getName());
    }

    @Before(exec)
    public void beforeMethod(JoinPoint joinPoint){
        logger.info(">>> Before " + joinPoint.getArgs().toString());
    }

    @AfterThrowing(value = exec, throwing = "e")
    public void afterMethod(JoinPoint joinPoint, Exception e){
        logger.error(">>> Error" + joinPoint.getSignature().getName()+"; ErrorMessage:"+e.getMessage());
    }

    @AfterReturning(value = "execution(* com.yang.test.Demo3.method2(..))", returning = "o")
    public void returnMethod(JoinPoint joinPoint, Object o){
        logger.info(">>> Return" + joinPoint.getTarget() + "; Return :" + o.toString());
    }
}
```
- 运行结果
```shell
09-04 09:52:35[INFO]com.yang.logger.MyLoggerAnnotation >>> Around >> 切面前
09-04 09:52:35[INFO]com.yang.logger.MyLoggerAnnotation >>> Before >>[Ljava.lang.Object;@64c63c79
———————  Start method  ———————
09-04 09:52:35[INFO]com.yang.logger.MyLoggerAnnotation >>> Around >>  Error :/ by zero
09-04 09:52:35[INFO]com.yang.logger.MyLoggerAnnotation >>> Around >> 切面后
09-04 09:52:35[INFO]com.yang.logger.MyLoggerAnnotation >>> After >>method
=====  Returning ====
———————  Start method2  ———————
09-04 09:52:35[INFO]com.yang.logger.MyLoggerAnnotation >>> Returncom.yang.test.Demo3@6eb2384f; Return :Annotation-Return
```

## 总结

| 增强处理类型 | 注解 | 特点 |
| ------------ | ---- | ---- |
| Before | @Before(value, argNames) | 前置增强处理，在目标方法前织入增强处理 |
|AfterReturning|@AfterReturning(value, pointcut,returning, argNames)|后置增强处理，在目标方法正常执行（不出现异常）后织入增强处理|
|AfterThrowing|@AfterThrowing(value,throwing)|异常增强处理，在目标方法抛出异常后织入增强处理|
|After|@After(value, argNames)|最终增强处理，不论方法是否抛出异常，都会在目标方法最后织入增强处理|
|Around|@Around(value, argNames)|环绕增强处理，在目标方法的前后都可以织入增强处理|

## 参考内容

 [05.AoP基本实现](https://www.bilibili.com/video/BV1TE411N7Hc?from=search&seid=4096017029823603152)

[09.增强处理](https://www.bilibili.com/video/BV1mE411A7hg?from=search&seid=7668663742364257843)

[10.环绕增强](https://www.bilibili.com/video/BV1PE411w7sZ?from=search&seid=5578020669846959998)

