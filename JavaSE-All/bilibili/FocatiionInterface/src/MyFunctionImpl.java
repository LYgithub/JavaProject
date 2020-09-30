/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/03/02.
 * Copyright © 2020 LiYang. All rights reserved.
 */

/**
 * @author LiYang
 * @Overridde
 * 监测方法是否重写
 *  是：编译成功
 *  否：编译不成功
 */
public class MyFunctionImpl implements MyFunctionInterface {
    @Override
    public void method() {
        System.out.println("method!");
    }

    public static void test(){
        System.out.println("test1");
    }

}
