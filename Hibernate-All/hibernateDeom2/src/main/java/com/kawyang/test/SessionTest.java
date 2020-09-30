package com.kawyang.test;

import com.kawyang.dao.IUserDao;
import com.kawyang.dao.UserDaoImpl;
import com.kawyang.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: hibernateDeom2
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class SessionTest {
    ///UserDaoImpl userDao = new UserDaoImpl();

    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void SessionTest(){
        if(userDao == null){
            System.out.println("null");
            return ;
        }
        SessionFactory sessionFactory = userDao.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int id = 5;
            int time = 1000;
            System.out.println("====> save");
            session.save(new User(id, "李四", "12345"));
            Thread.sleep(time);

            System.out.println("====> load");
            User load = session.load(User.class, id);
            System.out.println(load.toString());
            Thread.sleep(time);


            System.out.println("===> find");
            System.out.println(session.find(User.class, id));
            Thread.sleep(time);

            ///transaction.commit();
            //
            //transaction = session.beginTransaction();
            //System.out.println("===> update");
            //session.update(new User(id, "KawYang", "321"));

            ///通过修改持久化对象进行数据的更新
            System.out.println("===> update");
            load.setUserName("KawYang");
            Thread.sleep(time);

            System.out.println(session.find(User.class, id));
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                System.out.println("回滚。。。");
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
            new CRUDTest().delete();
        }
    }
}
