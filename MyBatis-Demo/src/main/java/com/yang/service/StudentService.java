package com.yang.service;

import com.yang.dao.StudentDao;
import com.yang.entity.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: com.yang.service
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Service
public class StudentService {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private StudentDao studentDao ;

    public Student findById(int id){
        return studentDao.findById(id);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public int insert(Student student){
        try{
            studentDao.insert(student);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Student student){
        return studentDao.update(student);
    }

    /**
     * 事务测试方法
     *
     * 现将数据进行修改，然后插入同一个 Key 数据，导致出现错误，查看是否修改成功？
     *     if  成功：事务起作用
     *     else ：事务出现错误
     * @param student
     */

    //@Transactional(rollbackFor = Exception.class)
    public void login(Student student){
        // 1、 查询
        Student byId = studentDao.findById(student.getId());
        if(byId != null){
            // 2、 修改
            int update = studentDao.update(student);
            logger.info("\n>>>>>>>>>> " + update);
            logger.info("\n>>>>>>>>>> " + studentDao.findById(student.getId()).toString());
            try {
                // 3、 插入出现错误
                studentDao.insert(student);
            }catch (RuntimeException e){
                logger.info("\n>>>>>>>>>> " + e.getMessage());
                throw e;
            }
            //studentDao.insert(student);

        }
    }

}
