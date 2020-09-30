package com.itcast;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: com.itcast
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class JDBCTemplateDemo {

    private static JdbcTemplate template = new JdbcTemplate(utils.JDBCutils.getDataSource());

    public static void main(String[] args) {
        String sql = "update student set age=? where age=?";
        int update = template.update(sql, 2, 21);
        System.out.println(update);
    }

    @Test
    public void Selcte_One(){
        //查询结果只能是1
        String sql = "Select * from student where age=?";
        Map<String , Object> map = template.queryForMap(sql,1);
        System.out.println(map);
    }

    @Test
    public void Selcte_All(){
        //查询结果只能是1
        String sql = "Select * from student";
        List<Map<String , Object>> map = template.queryForList(sql);
        System.out.println(map);
    }
    
    @Test
    public void test6(){
        String sql = "Select * from student";
        List<Student> query = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setAge(resultSet.getInt("age"));
                student.setScore(resultSet.getDouble("score"));
                student.setTime(resultSet.getString("birthday"));

                return student;
            }
        });
        System.out.println(query);
    }


    @Test
    public void test6_(){
        String sql = "Select * from student";
        List<Student> query = template.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(query);
    }

    @Test
    public void test7(){
        String sql = "Select count(*) from student";
        long number = template.queryForObject(sql, long.class);
        System.out.println(number);
    }


}
