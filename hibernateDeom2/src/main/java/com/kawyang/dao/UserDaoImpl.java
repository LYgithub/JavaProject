package com.kawyang.dao;

import com.kawyang.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author LiYang
 * @Project Name: hibernateDeom2
 * @Package Name: com.kawyang.dao
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@NoArgsConstructor
@Service
public class UserDaoImpl implements IUserDao {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public User findById(int id) {
        try(Session session = sessionFactory.openSession()) {
            User user = session.find(User.class, id);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insertUser(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            // 开启事务
            transaction = session.beginTransaction();
            int save =(Integer) session.save(user);
            // 提交事务
            transaction.commit();
            return save;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public int deleteById(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            return 0;
        }catch (Exception e){
            if(transaction != null){
                // 回滚事物
                transaction.rollback();
            }
            e.printStackTrace();
            return -1;
        }
    }
}
