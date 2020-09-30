package com.item.dao;

import com.item.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiY
 * 持久层
 */
public interface IUserDao {
    /**
     *  查询所有信息
     * @return 查询结果
     */
    List<User> findAll();

    /**
     * 注解查询
     * @return 结果
     */
    @Select("select * from user")
    List<User> findSom();

    /**
     * 插入数据
     * @param user
     * @return
     */
    int insert(User user);

    User selectByID(int id);
    int update(User user);
    int deleteByID(int id);

}
