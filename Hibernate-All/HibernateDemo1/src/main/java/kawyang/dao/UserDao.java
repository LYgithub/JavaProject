package kawyang.dao;

import kawyang.entity.User;

/**
 * @author LiYang
 * @Project Name: HibernateDemo1
 * @Package Name: kawyang.dao
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public interface UserDao {
    User findById(int id);
    int insertUser(User user);
    void updateUser(User user);
    int deleteById(User user);
}
