package Student;

import com.kawyang.entity.Classes;
import com.kawyang.entity.Student;
import com.kawyang.repository.IStudentRepository;
import com.kawyang.utils.MapperUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Student
 * Created by MacBook Air on 2020/07/03.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FindByStudent {
    public static void main(String[] args) {
        IStudentRepository mapper = MapperUtil.getMapper("config.xml", IStudentRepository.class);
        List<Student> byIds = mapper.findByStudent(new Student(1,"张三",new Classes()));
        System.out.println(Arrays.toString(byIds.toArray()));
    }
}
