package com.kawyang.repository.impl;

import com.kawyang.entity.Classes;
import com.kawyang.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBootDemo
 * @Package Name: com.kawyang.repository.impl
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Repository
public class ClassesRepositoryImpl implements ClassesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Classes> findAll() {
        return jdbcTemplate.query("select * from classes",
                new BeanPropertyRowMapper<>(Classes.class));

    }

    @Override
    public Classes findById(int id) {
        return  jdbcTemplate.queryForObject("select * from classes where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Classes.class) );
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from classes where id=?", id);
    }

    @Override
    public int save(Classes classes) {
        return jdbcTemplate.update("insert into classes (id,name) values (?,?);", classes.getId(), classes.getName());
    }

    @Override
    public int update(Classes classes) {
        return jdbcTemplate.update("update classes set name=? where id=?",classes.getName(), classes.getId());
    }
}
