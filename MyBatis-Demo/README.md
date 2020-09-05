# MyBatis-Spring-Demo

> MyBatis + MyBatis & Spring 练习

## MyBatisDemo
> `src/test/java/Test2` 文件练习

```java
// 加载配置文件
InputStream in = Test2.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
// 创建 工厂 Builder对象
SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
// 使用配置文件创建工厂
SqlSessionFactory build = builder.build(in);
// 使用工厂 创建 Session 会话对象 (缓存-- 一🐔缓存 -- Session🐔缓存)
SqlSession sqlSession = build.openSession();
// 获取 Mapper 对象 (缓存 -- 二🐔缓存 -- Mapper🐔缓存)
StudentDao mapper = sqlSession.getMapper(StudentDao.class);
System.out.println(mapper.findById(1).toString());
```

## MyBatis + Spring

> 将 MyBatis 使用的对象 全部交给 IoC 容器进行管理，使用方便  
> MyBatis 使用过程 :  SqlSessionFactoryBuilder => SqlSessionFactory => SqlSession => Mapper
> 将 SqlSessionFactoryBuilder、SqlSessionFactory 、SqlSession 交给IoC 容器

### 自动扫描[^1]

>  `<context:component-scan>` 自动扫描标签，包括一下两个字标签，`<context:include-filter>` 、` <context:exclude-filter>`  

- 基本配置

```xml
<context:component-scan base-package="com.yang" use-default-filters="false">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    <!-- 通过 type 辅助扫描的类 annotation 指定注解所指的类 共五种类型(参考1) -->
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Component"/>
</context:component-scan>
```

### 注解

- @Service : 用于标注`业务层`组件
- @Repository : 用于标注`数据访问`组件
- @Controller : 用于标注`控制层`组件
- @Component : 其他组件

### 步骤

- 导入依赖

> 数据库：mysql-connector-java、mybatis、mybatis-generator-core、c3p0
>
> Spring: spring-context、spring-core、mybatis-spring、spring-jdbc
>
> 其他：lombok、log4j、junit-jupiter

```xml
<!--  环境配置  -->
<build>
    <!-- 配置文件  -->
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
    <!-- 设置编译JDK 版本   -->
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <source>14</source>
                <target>14</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

- 类对象

> @Component  将类对象注入到IoC容器

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
    int id;
    String name;
    int cid;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                '}';
    }
}
```

- Dao 接口

> @Select 使用注解形式 配置 Mapper

```java
public interface StudentDao {
    public Student findById(int id);
    
    @Select("select * from student")
    public List<Student> findAll();
}
```

- Service层

> @Service 将 Service 对象 注入到 IoC 容器

```java
@Service
public class StudentService {

    // 使用 IoC 容器自动注入 Dao 对象
    @Autowired
    private StudentDao studentDao ;

    public Student findById(int id){
        return studentDao.findById(id);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }
}
```

- 配置文件

1、MyBatis配置 - config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- SQL配置 -->
    <settings>
        <!-- 现实SQL语句  -->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>

    <typeAliases>
        <!-- 指定一个包名，MyBatis会在包名下搜索需要的JavaBean-->
        <package name="com.yang.entity"/>
    </typeAliases>

</configuration> 
```

2、Spring配置 -  applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd http://www.springframework.org/schema/cache http://www.springframework.org/schema/cache/spring-cache.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">

    
    <context:component-scan base-package="com.yang" />
    <!-- 加载外部配置文件 -->
    <context:property-placeholder location="classpath:dbconfig.properties" />
    <context:annotation-config />


    <!-- 配置数据源信息  -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.user}" />
        <property name="password" value="${jdbc.password}" />
        <property name="driverClass" value="${jdbc.driver}" />
        <property name="maxPoolSize" value="10" />
        <property name="minPoolSize" value="5" />
        <property name="loginTimeout" value="1000" />
    </bean>

    <!-- 创建  SqlSessionFactory 工厂  -->
    <!-- 工厂的配置 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean" >

        <!-- 加载 MyBatis 配置文件   -->
        <property name="configLocation" value="classpath:config.xml" />
        <!-- 设置数据源信息 -->
        <property name="dataSource" ref="dataSource" />
        <!-- 配置 Mapper 位置 -->
        <property name="mapperLocations" >
            <list>
                <value>classpath:com/yang/mapper/StudentMapper.xml</value>
            </list>
        </property>
    </bean>

    <!-- 使用包扫描创建代理对象，包下面所有Mapper接口统一创建代理对象 使用桥梁包下面 ： org.mybatis.spring.mapper.MapperScannerConfigurer
            可以包扫描创建所有映射接口的代理对象 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!-- 配置 SqlSessionFactoryBean 的名称 -->
        <property name="basePackage" value="com.yang.dao"/>
        <!-- 可选，如果不写，Spring启动时候。容器中。自动会按照类型去把SqlSessionFactory对象注入进来 -->
        <!-- <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/> -->

    </bean>

    <!--✅ 事务控制配置 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!-- 控制数据源,数据源的开启和关闭 -->
        <property name="dataSource" ref="dataSource" />
    </bean>
</beans>
```

- 测试类

```java
@org.junit.jupiter.api.Test
public void main() {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    StudentService bean = context.getBean(StudentService.class);
    System.out.println(bean.findById(1).toString());
    System.out.println(Arrays.toString(bean.findAll().toArray()));
}
```

## 事务管理

> 将 部分操作作为一个整体，要么全部 SQL 执行完成，要么全部不执行，需要将这个是操作作为一个事务进行操作。
### 使用

- Spring 配置文件
```xml
<!--✅ 事务控制配置 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!-- 控制数据源,数据源的开启和关闭 -->
    <property name="dataSource" ref="dataSource" />
    <property name="rollbackOnCommitFailure" value="false" />
</bean>

<!-- 如何切入 ，进行关联-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <!--  优化查询  -->
        <tx:method name="find*" read-only="true" />
        <!--  全部错误回滚 (必须在抛出异常 不能被捕获) -->
        <tx:method name="*" rollback-for="Exception" />
    </tx:attributes>
</tx:advice>

<!--  面向切面  -->
<aop:config>
    <!--  切入需要回滚的方法  -->
    <aop:pointcut id="txPoint" expression="execution( * com.yang.service..*(..))"/>
    <!--  配置事务增强  -->
    <aop:advisor  advice-ref="txAdvice" pointcut-ref="txPoint"/>
</aop:config>
```
### 事务不回顾情况

> 默认情况下，如果在事务中抛出了`未检查异常`（继承自 RuntimeException 的异常）或者 Error，则 Spring 将回滚事务；除此之外，Spring 不会回滚事务。
 
> 如果在事务中抛出其他类型的异常，并期望 Spring 能够回滚事务，可以`指定 rollbackFor`。例：`@Transactional(propagation= Propagation.REQUIRED,rollbackFor= MyException.class)`

> 通过分析 Spring 源码可以知道，若在目标方法中抛出的异常是 `rollbackFor` 指定的异常的子类，事务同样会回滚。



# 参考内容



- [Mybatis MapperScannerConfigurer 自动扫描 将Mapper接口生成代理注入到Spring](https://blog.csdn.net/AD921012/article/details/50051707)  
- [Spring中IoC容器的注入方式](https://www.cnblogs.com/dmir/p/4876125.html)  
- [spring注解@service("service")括号中的service有什么用](https://blog.csdn.net/weixin_42476601/article/details/86137375)
- [透彻的掌握 Spring 中 @transactional 的使用](https://developer.ibm.com/zh/articles/j-master-spring-transactional-use/)

[^1]:[<context:component-scan>详解](https://www.cnblogs.com/fightingcoding/p/component-scan.html)
  
[^2]:[DataSourceTransactionManager](https://blog.csdn.net/xinzhiyishi/article/details/83540909)
[^3]:[@Transactional事务出现异常不回滚的处理](https://blog.csdn.net/sinat_32023305/article/details/84105837)
[^4]:[Spring事务管理之回滚异常rollback-for](https://blog.csdn.net/jylinxmu/article/details/80826989)
