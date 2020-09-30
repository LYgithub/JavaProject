package 设计模式.工厂模式.abstractfactory.colorimpl;

import 设计模式.工厂模式.abstractfactory.Color;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstractfactory.colorimpl
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("color:blue");
    }
}
