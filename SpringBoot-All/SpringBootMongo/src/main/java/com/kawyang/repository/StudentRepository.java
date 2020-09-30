package com.kawyang.repository;

import com.kawyang.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiYang
 * @Project Name: SpringBootMongo
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/06/29.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
