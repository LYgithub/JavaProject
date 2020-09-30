package com.item.factory;

import com.item.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item.factory
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class InstanceCarFactory {
    private Map<Long, Car> carMap;

    public InstanceCarFactory() {
        carMap = new HashMap<Long, Car>();
        carMap.put(1L, new Car(1L,"宝马"));
        carMap.put(2L, new Car(2L,"奔驰"));
    }

    public Car getCar(Long id){
        return carMap.get(id);
    }
}
