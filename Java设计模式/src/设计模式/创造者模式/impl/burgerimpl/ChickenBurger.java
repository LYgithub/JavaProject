package 设计模式.创造者模式.impl.burgerimpl;

import 设计模式.创造者模式.Burger;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.itemimpl
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ChickenBurger extends Burger {
    /**
     * price
     *
     * @return
     */
    @Override
    public float price() {
        return 3.2f;
    }

    /**
     * name
     *
     * @return
     */
    @Override
    public String name() {
        return "Burger:ChickenBurger";
    }
}
