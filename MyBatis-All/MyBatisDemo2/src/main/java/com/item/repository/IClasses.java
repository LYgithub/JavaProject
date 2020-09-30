package com.item.repository;

import com.item.entity.Classes;
import com.item.entity.Classes_;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: com.item.repository
 * Created by MacBook Air on 2020/06/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IClasses {

    /**
     * find All
     * @return 返回
     * 简单单标查询
     */
    List<Classes_> findAll();

    Classes_ findById(int id);

    /**
     * find By All
     * @return 返回
     * 连带学生信息查询班级
     */
    List<Classes> findByAll();


}
