package Student;

import com.kawyang.entity.ListIds;
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
public class FindByIds {
    public static void main(String[] args) {
        IStudentRepository mapper = MapperUtil.getMapper("config.xml", IStudentRepository.class);
        List<Student> byIds = mapper.findByIds(new ListIds(Arrays.asList(2,3,4)));
        System.out.println(Arrays.toString(byIds.toArray()));
    }
}
