package Student;

import com.kawyang.entity.Student;
import com.kawyang.repository.IStudentRepository;
import com.kawyang.utils.MapperUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Student
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        IStudentRepository mapper =
                MapperUtil.getMapper("config.xml",IStudentRepository.class);
        Student byId = mapper.findById(3);
        System.out.println(byId);
        List<Student> all = mapper.findAll();

        System.out.println(Arrays.toString(all.toArray()));
    }
}
