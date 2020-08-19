/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/03/02.
 * Copyright © 2020 LiYang. All rights reserved.
 * 函数式接口
 * 默认方法\静态方法、私有方法
 *
 */

/**
    可以监测是否是一个编译
    @author LiYang

 函数式接口，只包含一个抽象方法
 */

@FunctionalInterface
public interface MyFunctionInterface {

    /**
        定义一个抽象方法(只有一个)
     */
    public abstract void method();

    /**
     *
     */
    static void test(){
        System.out.println("test");
    }


}
