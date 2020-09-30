package com.item.repository;

import com.item.entity.Good;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: com.item.repository
 * Created by MacBook Air on 2020/06/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IGood {

    /**
     * 查找所有商品的购买客户
     * @return
     */
    List<Good> findAll();
}
