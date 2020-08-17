package com.itcast.jdbc;

import utils.JDBCtools;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: com.itcast.jdbc
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo2 {
    public static void main(String[] args){
        insert();
        modify();
//        delete();

        selectShow();
        List<Student> list=findAll();
        System.out.println(list);

    }

    /**
     * 查询所有对象
     * @return
     */
    private static List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("JDBC:MYSQL:///test", "root", "liyangLY");
            String sql = "select * from student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                //是否为最后一行末尾
                list.add(new Student(resultSet.getInt("age"),resultSet.getDouble(2),null));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            close(connection, statement);
            return list;
        }
    }

    private static void selectShow() {
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("JDBC:MYSQL:///test", "root", "liyangLY");
            String sql = "select * from student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                //是否为最后一行末尾
                System.out.println(resultSet.getInt("age") +"\t" + resultSet.getDouble(2) + "\t"
                        + resultSet.getDouble(3));
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            close(connection, statement);
        }
    }

    private static void delete() {
        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("JDBC:MYSQL:///test", "root", "liyangLY");
            String sql = "delete from student where age=2";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Error:Modify" + e.getMessage());
        }finally {
            close(connection, statement);
        }
    }

    public static void modify(){
        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("JDBC:MYSQL:///test", "root", "liyangLY");
            String sql = "update student set age=2 where age=23";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Error:Modify" + e.getMessage());
        }finally {
            close(connection, statement);
        }
    }

    private static void close(Connection connection, Statement statement) {
        JDBCtools.close(connection, statement);
    }

    public static void insert(){
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into student values (23, 90.88, NULL)";
            connection = DriverManager.getConnection("JDBC:MYSQL:///test", "root", "liyangLY");
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);

        }catch (Exception e){
            System.out.println("Error:Insert");
        }finally {
            close(connection, statement);
        }
    }

}

class Student{
    int age;
    double score;
    Date time;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int age, double score, Date time) {
        this.age = age;
        this.score = score;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", time=" + time +
                '}';
    }
}
