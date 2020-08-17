package com.kawyang.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
public class Person {
    int id;
    String name;
    Address address;
    String sex;
    boolean remember;
    List<String> hobby;
    List<String> selecthobby;

    Map<Integer,String> classesList;
    int classes;
    List<String> citys;
    String city;

    String introduce;

}
