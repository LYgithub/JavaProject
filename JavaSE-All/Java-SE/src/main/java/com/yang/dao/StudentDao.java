package com.yang.dao;

import com.yang.util.ConnectionUtils;

/**
 * @author LiYang
 * @Project Name: Java-SE
 * @Package Name: com.yang.dao
 * Created by MacBook Air on 2020/09/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class StudentDao {
    public void add(){

        System.out.println(this.getClass().getName() + " -> add -> " + ConnectionUtils.getThreadLocal().toString());
    }
}
