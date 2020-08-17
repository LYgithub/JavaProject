package 设计模式.工厂模式.abstractfactory;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.工厂模式.abstractfactory
 * Created by MacBook Air on 2020/07/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
abstract public class AbstractFactory {
    /**
     * s
     * @param type
     * @return
     */
    public abstract Shape getShape(String type);

    /**
     * s
     * @param type
     * @return
     */
    public abstract Color getColor(String type);
}
