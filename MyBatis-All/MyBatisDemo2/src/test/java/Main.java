import com.item.entity.Classes;
import com.item.entity.Classes_;
import com.item.repository.IClasses;
import com.item.repository.IStudent;
import com.item.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/13.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 *
 * 基础练习
 *
 * 简单查询数据库信息
 */
public class Main {
    public static void main(String[] args) {
        //读取
        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IStudent mapper = sqlSession.getMapper(IStudent.class);
        //插入数据库
//        Student student = new Student(4, "xx4", new Classes(1,"一班", null));
//        int i = mapper.insertStudent(student);
//        System.out.println(i);
//        sqlSession.commit();

//        List<Student> all = mapper.findByAll();
//        for (Student stu:all) {
//            System.out.println(stu);
//        }

        Student byId1 = mapper.findById(1);
        System.out.println(byId1);



        IClasses mapper1 = sqlSession.getMapper(IClasses.class);
//        List<Classes_> classes = mapper1.findAll();
//        for (Classes_ clas : classes) {
//            System.out.println(clas);
//        }

        Classes_ byId = mapper1.findById(byId1.getId());
        System.out.println(byId);

        System.out.println("-------------------------");
        String name = mapper.findById(2).getName();
        System.out.println(name);

        sqlSession.close();
    }
}
