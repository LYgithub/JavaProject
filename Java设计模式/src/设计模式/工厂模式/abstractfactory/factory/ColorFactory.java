package 设计模式.工厂模式.abstractfactory.factory;

import 设计模式.工厂模式.abstractfactory.AbstractFactory;
import 设计模式.工厂模式.abstractfactory.Color;
import 设计模式.工厂模式.abstractfactory.Shape;
import 设计模式.工厂模式.abstractfactory.colorimpl.Blue;
import 设计模式.工厂模式.abstractfactory.colorimpl.Red;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstract factory.factory
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String type) {
        return null;
    }

    @Override
    public Color getColor(String type) {
        switch (type){
            case "Red":
                return new Red();
            case "Blue":
                return  new Blue();
            default:
                return null;
        }
    }
}
