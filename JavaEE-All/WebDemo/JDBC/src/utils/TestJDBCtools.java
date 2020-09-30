package utils;

import org.junit.Test;


/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: utils
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */


public class TestJDBCtools {
    @Test
    public void testInsert(){
        String sql = "insert into student values(21, 90.98, '1998-12-30')";
        JDBCtools.insert(sql);
    }


    @Test
    public void testSelectPro(){
        String age = "21";
        String score = "901.98";
        if( age == null || score == null){
            System.out.println("登录失败！");
            return ;
        }
        String sql = "select * from student where age=? and score=?";

        if(JDBCtools.selectPro(sql, age, score)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }
    @Test
    public void testSelect(){
        String age = "21";
        String score = "90.98";
        if( age == null || score == null){
            System.out.println("登录失败！");
            return ;
        }
        String sql = "select * from student where age="+age+" and score=" + score;



        if(JDBCtools.select(sql)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }
}
