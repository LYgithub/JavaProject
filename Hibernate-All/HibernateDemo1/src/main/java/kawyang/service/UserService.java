package kawyang.service;

import kawyang.dao.UserDao;
import kawyang.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author LiYang
 * @Project Name: HibernateDemo1
 * @Package Name: kawyang.service
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Service
public class UserService implements UserDao {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

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
        try(Session session = sessionFactory.openSession()){
            int save =(Integer) session.save(user);
            return save;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void updateUser(User user) {
        try(Session session = sessionFactory.openSession()){
            session.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int deleteById(User user) {
        try(Session session = sessionFactory.openSession()){
            session.delete(user);
            return 0;
        }
    }
}
