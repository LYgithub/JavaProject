/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/03/02.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo {
    public static void main(String[] args) {
        show(new MyFunctionImpl());
        show(new Test());
        show(() -> System.out.println("--sds"));
        show(() ->
            System.out.println("test")
        );

    }

    /**
     * 方法的参数是一个接口，可以传递实现类对象
     * @param myInter
     */
    public static void show(MyFunctionInterface myInter){
        myInter.method();
    }
}

class Test implements MyFunctionInterface {

    @Override
    public void method() {
        System.out.println("test_method!");
    }
}
