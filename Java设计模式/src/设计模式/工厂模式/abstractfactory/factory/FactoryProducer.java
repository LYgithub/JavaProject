package 设计模式.工厂模式.abstractfactory.factory;

import 设计模式.工厂模式.abstractfactory.AbstractFactory;


/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstractfactory.factoryimpl
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FactoryProducer{
    public AbstractFactory getFactory(String type){
        if("Color".equals(type)){
            return new ColorFactory();
        }else if ("Shape".equals(type)){
            return new ShapeFactory();
        }
        else {
            return null;
        }
    }
}
