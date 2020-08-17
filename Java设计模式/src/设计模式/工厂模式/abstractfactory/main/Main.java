package 设计模式.工厂模式.abstractfactory.main;

import org.junit.Test;
import 设计模式.工厂模式.abstractfactory.AbstractFactory;
import 设计模式.工厂模式.abstractfactory.factory.FactoryProducer;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstractfactory.main
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    @Test
    public void test1(){
        FactoryProducer factoryProducer = new FactoryProducer();
        AbstractFactory color = factoryProducer.getFactory("Color");
        color.getColor("Red").fill();

        color.getColor("Blue").fill();

        AbstractFactory shape = factoryProducer.getFactory("Shape");
        shape.getShape("Circle").draw();

        shape.getShape("Square").draw();

    }
}
