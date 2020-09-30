import com.yang.IUtil;
import com.yang.MyInvocationHandler;
import com.yang.Util;

import java.lang.reflect.Proxy;

/**
 * @author LiYang
 * @Project Name: Proxy-newProxyInstance
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/08/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Util util = new Util();
        util.run("do");
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.setObject(util);
        IUtil o = (IUtil)Proxy.newProxyInstance(
                util.getClass().getClassLoader(),
                util.getClass().getInterfaces(),
                myInvocationHandler);
        o.run("do-something");
    }
}
