package 设计模式.结构模型.装饰者模式;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.结构模型.装饰者模式
 * Created by MacBook Air on 2020/07/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.operation();

        ConcreteDecorator1 concreteDecorator1 = new ConcreteDecorator1(new ConcreteComponent());
        concreteDecorator1.operation();


        ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(concreteDecorator1);
        concreteDecorator2.operation();
    }
}

interface  Component{
    /**
     * 拍照功能
     */
    void operation();
}

class  ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("拍照！");
    }
}

abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();
    }
}

class ConcreteDecorator2 implements Component{
    ConcreteDecorator1 concreteDecorator1;

    public ConcreteDecorator2(ConcreteDecorator1 concreteDecorator1) {
        this.concreteDecorator1 = concreteDecorator1;
    }

    /**
     * 拍照功能
     */
    @Override
    public void operation() {
        System.out.println("添加滤镜！");
        concreteDecorator1.operation();
    }
}
