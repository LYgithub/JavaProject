package Student;

import com.kawyang.entity.ClassesStu;
import com.kawyang.entity.Student;
import com.kawyang.repository.IClassRepository;
import com.kawyang.repository.IStudentRepository;
import com.kawyang.utils.MapperUtil;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Student
 * Created by MacBook Air on 2020/07/03.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class LazyFind {
    public static void main(String[] args) {
        IStudentRepository mapper = MapperUtil.getMapper("config.xml", IStudentRepository.class);
        Student byIdLazy = mapper.findByIdLazy(2);
        System.out.println(byIdLazy.getName());
        System.out.println("------------");
        System.out.println(byIdLazy.getClasses().getName());



        IClassRepository mapper1 = MapperUtil.getMapper("config.xml", IClassRepository.class);
        ClassesStu byIdLazy1 = mapper1.findByIdLazy(2);
        System.out.println(byIdLazy1.getName());
        System.out.println("------------");
        System.out.println(byIdLazy1.getStudents());
    }
}
