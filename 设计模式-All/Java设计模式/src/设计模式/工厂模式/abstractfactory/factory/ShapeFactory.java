package 设计模式.工厂模式.abstractfactory.factory;

import 设计模式.工厂模式.abstractfactory.AbstractFactory;
import 设计模式.工厂模式.abstractfactory.Color;
import 设计模式.工厂模式.abstractfactory.Shape;
import 设计模式.工厂模式.abstractfactory.shapeimpl.Circle;
import 设计模式.工厂模式.abstractfactory.shapeimpl.Square;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstractfactory.factory
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String type) {
        switch (type){
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            default:
                return null;
        }
    }

    @Override
    public Color getColor(String type) {
        return null;
    }
}
