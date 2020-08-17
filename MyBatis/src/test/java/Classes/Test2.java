package Classes;

import com.kawyang.model.ClassesStudents;
import com.kawyang.repository.IClass;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: Classes
 * Created by MacBook Air on 2020/06/24.
 * Copyright © 2020 LiYang. All rights reserved.
 * 一对多
 */
public class Test2 {
    public static void main(String[] args) {
        InputStream resourceAsStream = Test2.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IClass mapper = sqlSession.getMapper(IClass.class);
        ClassesStudents classAndStudentById = mapper.findClassAndStudentById(1);
        System.out.println(classAndStudentById);

        List<ClassesStudents> allClassAndStudent = mapper.findAllClassAndStudent();
        System.out.println(allClassAndStudent);

        //释放资源
        sqlSession.close();

    }
}
