package com.sqlPlus.repository;

import com.sqlPlus.entity.Classes;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MBGDemo
 * @Package Name: com.sqlPlus.repository
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IClasses {

    /**
     * findAll
     * @return
     */
//    @Select("select * from classes")
    List<Classes> findAll();
}
