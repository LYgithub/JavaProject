package 设计模式.创造者模式;

import 设计模式.创造者模式.colddrink.Coke;
import 设计模式.创造者模式.colddrink.Pepsi;
import 设计模式.创造者模式.impl.burgerimpl.ChickenBurger;
import 设计模式.创造者模式.impl.burgerimpl.VegBurger;


/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MealBuilder {

    /**
     * 控制内部属性的创建过程
     * @return
     */
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public Meal prepareTest(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
}