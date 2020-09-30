package 设计模式.创造者模式.impl.packimpl;

import 设计模式.创造者模式.Packing;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.impl.packimpl
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
