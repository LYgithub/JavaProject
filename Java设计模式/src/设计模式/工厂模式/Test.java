package 设计模式.工厂模式;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: 设计模式.工厂模式
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */


public class Test{
    public static void main(String[] args) {
        BWMFactory factory = new BWM3Factory();
        System.out.println(factory.ProductBWM());


        BWM b3 = new BWM3Factory().ProductBWM();
        b3.showInfo();

        BWM b4 = new BWM4Factory().ProductBWM();
        b4.showInfo();
    }
}