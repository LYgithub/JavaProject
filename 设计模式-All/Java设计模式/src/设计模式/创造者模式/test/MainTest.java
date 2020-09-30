package 设计模式.创造者模式.test;

import org.junit.Test;
import 设计模式.创造者模式.Meal;
import 设计模式.创造者模式.MealBuilder;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.test
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MainTest {
    @Test
    public void test1(){
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());


        Meal meal = mealBuilder.prepareTest();
        System.out.println("------- test -------");
        meal.showItems();
        System.out.println(meal.getCost());
    }
}
