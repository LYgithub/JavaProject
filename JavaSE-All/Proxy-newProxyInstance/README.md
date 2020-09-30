# 动态代理

> 通过设置代理对象，可以在不改变原代码的基础上，对方法进行拓展
>
> 将与类对象无关的内容提取出来，降低程序的耦合性

1. 创建接口
2. 接口实现类
3. 创建代理对象
4. 用代理对象调用方法

# 代理类和委托类区别

>  代理类与委托类具有相同的接口，但`委托类`是接口的`真正实现者`，`代理类`只是调用委托类的相关方法来提供特定的服务，代理类可以为委托类预处理信息、把信息传递给委托类处理并进行事后处理。
>
> 代理类分为`静态代理类`和`动态代理类`。

# 步骤

## 创建接口

```java
public interface IUtil {
    void run(String something);
}
```

## 接口实现类

```java
public class Util implements IUtil{

    @Override
    public void run(String something) {
        System.out.println(something);
    }
}
```

## 创建代理对象

```java
@Data
public class MyInvocationHandler implements InvocationHandler {
    /** 委托对象 */
    private Object object = null;

    @Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
        System.out.println("----- start -----");
        Object invoke = method.invoke(object, args);
        System.out.println("----- end -----");
        return invoke;
    }
}
```

## 使用代理对象完成操作

```java
Util util = new Util();
MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
myInvocationHandler.setObject(util);
IUtil o = (IUtil)Proxy.newProxyInstance(
        util.getClass().getClassLoader(),
        util.getClass().getInterfaces(),
        myInvocationHandler);
o.run("do-something");
```

# 参考内容


[java动态代理Proxy.newProxyInstance](https://blog.csdn.net/u012326462/article/details/81293186)