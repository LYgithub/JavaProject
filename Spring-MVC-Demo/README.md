## Spring-MVC

> Spring-MVC 是视图层框架

### 


## AoP
> Aspect Oriented Programming  ---- 面向切面编程
> 在不改变原代码的基础上，对程序进行拓展，增强方法内容。
> 将项目公共代码提取出来，进行同意管理。

 - 降低耦合度
 - 易拓展
 - 复用
 - 非业务集中，便于统一管理
 - 业务代码比较纯粹，没有其他代码影响
 
### 关键词
 
 - 增强处理(Advice)：切入的公共代码
 - 切面(Aspect)：横切关注点被模块化的抽象对象
 - 通知：切面对象完成的工作（非业务代码，日志...）
 - 目标(Target Object)：被通知的对象，即被切面的对象
 - AOP代理(AOP Proxy)：切面、通知、目标混合之后的对象
 - 连接点(Join Point)：通知插入业务代码的具体位置，获取方法的`参数`
 - 切点(Point Cut)：AOP通过切点定位到连接点
 - 织入(Weaving)：切入，动态织入
 
### 入门
 
- 编写公共代码类 (MyLogger)
- 在 applicationContext.xml 中进行配置 
> 先引入相关约束  `xmlns:aop="http://www.springframework.org/schema/aop"` ..
> 然后编写配置

 ```xml
<!--  后置增强  -->
<aop:config>
    <!-- 设置切点 execution 匹配相关切入对象 -->
    <aop:pointcut id="point" expression="execution(* com.yang.controller.*.*(..))"/>
    <!-- 配置切面，log 需要先配置相应的 bean -->
    <aop:aspect ref="log">
        <!-- 后置增强，在方法结束后执行，必须指定切点 -->
        <aop:after method="AfterLog" pointcut-ref="point" />
    </aop:aspect>
</aop:config>
```
- 运行切入对象进行测试

### 增强

### 异常抛出增强

