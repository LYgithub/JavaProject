package com.item.repository;

import com.item.entity.Consumer;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: com.item.repository
 * Created by MacBook Air on 2020/06/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IConsumer {

    /**
     * fina all
     * @return 查找
     */
    List<Consumer> findAll();
}
