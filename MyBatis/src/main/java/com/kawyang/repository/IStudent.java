package com.kawyang.repository;

import com.kawyang.model.Student;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: com.kewyang.repository
 * Created by MacBook Air on 2020/06/23.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public interface IStudent {

    Student findById(int id);

}
