package com.yang.service;

import com.yang.dao.ClassDao;
import com.yang.dao.StudentDao;

import java.util.Collection;

/**
 * @author LiYang
 * @Project Name: Java-SE
 * @Package Name: com.yang.service
 * Created by MacBook Air on 2020/09/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class LoginService {
    ClassDao classDao = new ClassDao();
    StudentDao studentDao = new StudentDao();

    public void login(){
        classDao.add();
        studentDao.add();
    }
}
