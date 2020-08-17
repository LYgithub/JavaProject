package 设计模式.工厂模式;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: 设计模式.工厂模式
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */

interface BWM {
    /**
     * 宝马车
     */
    void showInfo();
}


/**
 * 宝马3系列
 * 构建具体的类
 */
class BWM3i implements BWM{
    @Override
    public void showInfo() {
        System.out.println("这是宝马3系列");
    }
}

/**
 * 宝马4系列
 * 构建具体的类
 */
class BWM4 implements BWM{
    @Override
    public void showInfo() {
        System.out.println("这是宝马4系列");
    }
}
