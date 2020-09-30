package com.kawyang.converter;

import com.kawyang.entity.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.converter
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class StudentConverter implements Converter<String, Student> {
    @Override
    public Student convert(String s) {
        String[] split = s.split("-");
        Student student = new Student(Long.parseLong(split[0]), split[1], Integer.parseInt(split[2]));
        System.out.println(student);
        return student;
    }
}
