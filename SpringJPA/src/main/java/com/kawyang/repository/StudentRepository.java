package com.kawyang.repository;

import com.kawyang.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiYang
 * @Project Name: SpringJPA
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/06/29.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * find by id
     * @param id
     * @return student
     */
    public Student getById(Long id);
}
