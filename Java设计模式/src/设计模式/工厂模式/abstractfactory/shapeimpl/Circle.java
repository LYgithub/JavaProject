package 设计模式.工厂模式.abstractfactory.shapeimpl;

import 设计模式.工厂模式.abstractfactory.Shape;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstractfactory.shapeimpl
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("shale:Circle!");
    }
}
