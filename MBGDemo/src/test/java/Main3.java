import com.sqlPlus.entity.Classes;
import com.sqlPlus.entity.Student;
import com.sqlPlus.repository.IClasses;
import com.sqlPlus.repository.IStudent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MBGDemo
 * @Package Name: com.sqlPlus
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main3 {
    public static void main(String[] args) {
        //读取配置文件
        InputStream resourceAsStream = Main3.class.getClassLoader().getResourceAsStream("MapperConfig.xml");
        System.out.println(resourceAsStream);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IStudent mapper = sqlSession.getMapper(IStudent.class);
        List<Student> all = mapper.findAll();
        for (Student stu: all) {
            System.out.println(stu);
        }

        IClasses mapper1 = sqlSession.getMapper(IClasses.class);
        List<Classes> all1 = mapper1.findAll();
        for (Classes clas: all1) {
            System.out.println(clas);
        }
        sqlSession.close();
    }
}
