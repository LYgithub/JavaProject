package com.yang;


import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: com.yang
 * Created by MacBook Air on 2020/08/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ManFactory {
    static Map<String , Man> map;
    static {
        map = new HashMap<>();
        map.put("张三", new Man("张三"));
        map.put("李四", new Man("李四"));
    }

    public static Man getMan(String key){
        return map.get(key);
    }


    public Man getMan0(String name){
        return map.get(name);
    }
}
