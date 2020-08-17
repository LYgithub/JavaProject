package 设计模式.创造者模式;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface Item {
    /**
     * name
     * @return
     */
    public String name();

    /**
     * pack
     * @return
     */
    public Packing packing();

    /**
     * price
     * @return
     */
    public float price();

}
