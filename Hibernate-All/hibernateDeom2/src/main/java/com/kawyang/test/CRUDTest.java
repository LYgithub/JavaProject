package com.kawyang.test;


import com.kawyang.dao.UserDaoImpl;
import com.kawyang.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

/**
 * @author LiYang
 * @Project Name: hibernateDeom2
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class CRUDTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void insert() {
        try{
            User user = new User(null,"张三","121112");
            System.out.println(userDao.insertUser(user));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void update(){
        try{
            User user = new User(2,"KawYang","12345");
            userDao.updateUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try{
            User user = new User(5,null,null);
            userDao.deleteById(user);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findByid(){
        try{
            System.out.println(userDao.findById(1));
            System.out.println(userDao.findById(3));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
