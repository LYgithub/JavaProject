package 设计模式.工厂模式;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: 设计模式.工厂模式
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */

interface BWMFactory {
    /**
     * 宝马工厂
     * @return 返回宝马类型
     */
    BWM ProductBWM();
}

/**
 *  宝马3 生产工厂
 */
class BWM3Factory implements BWMFactory{
    @Override
    public BWM ProductBWM() {
        System.out.println("生产宝马3系列！");
        return new BWM3i();
    }
}

/**
 *  宝马4 生产工厂
 */
class BWM4Factory implements BWMFactory{
    @Override
    public BWM ProductBWM() {
        System.out.println("生产宝马4系列！");
        return new BWM4();
    }
}

