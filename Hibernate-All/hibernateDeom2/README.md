# 总结

## Hibernate CRUD

**1、配置好映射文件**

**2、编写 Dao 层，完成数据的访问**

**2、1  创建 Configuration 对象**

```java
Configuration configuration = new Configuration().configure();
```
**2、2 使用 Configuration 对象创建 SessionFactory 工厂类**

```java
SessionFactory sessionFactory = configuration.buildSessionFactory();
```
**2、3 打开 Session 对象**

```java
Session session = sessionFactory.openSession();
```
**2、4  使用 Session 创建 事务**

```java
transaction = session.beginTransaction();
```
**2、5 完成数据库操作**

```java
session.save|update|delete(user);
```
**2、6 提交事务**

```java
transaction.commit();
```
**2、7 异常回滚事务**

```java
transaction.rollback();
```

## Session

> Session 级缓存是 Hibernate 一级缓存，存放相关联的 java 对象，成为持久化对象，根据持久化对象的状态同步更新到数据库。它是自动维护的，无需人工干预。

