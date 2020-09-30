import com.item.entity.Classes;
import com.item.entity.Student;
import com.item.repository.IClasses;
import com.item.repository.IStudent;
import org.apache.ibatis.session.SqlSession;
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
 * 一对多练习
 *
 * 一个班级可以有多个学生，多个学生可以在一个班级，班级与学生是一对多
 *
 *
 * 多对一
 *
 * 一个学生对应一个班级，一个班级对应多个学生，学生与班级是多对一
 */
public class Main2 {
    public static void main(String[] args) {
        InputStream resourceAsStream = Main2.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = builder.build(resourceAsStream).openSession();

        System.out.println("-------- 多对一 --------");

        IStudent mapper = sqlSession.getMapper(IStudent.class);

        List<Student> byAll = mapper.findByAll();
        for (Student stu :
                byAll) {
            System.out.println(stu);
        }
        System.out.println("-------- " + "一对多" + " --------" ) ;

        IClasses mapper1 = sqlSession.getMapper(IClasses.class);
        List<Classes> byAll1 = mapper1.findByAll();
        for (Classes clas : byAll1) {
            System.out.println(clas);
        }
        sqlSession.close() ;

    }

}
