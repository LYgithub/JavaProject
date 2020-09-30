package 设计模式.创造者模式;

import 设计模式.创造者模式.impl.packimpl.Wrapper;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.itemimpl
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public abstract class Burger implements Item {
    /**
     * pack
     *
     * @return
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * price
     *
     * @return
     */
    @Override
    public abstract float price() ;
}
