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
       <aop:Before ></aop:Before>
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

#### Around

- 待学习

