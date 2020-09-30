package Student;

import com.kawyang.model.Student;
import com.kawyang.repository.IStudent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: Student
 * Created by MacBook Air on 2020/06/23.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 * 多表查询
 *  懒加载
 */
public class Test1 {
    public static void main(String[] args) {
        //读取配置文件
        InputStream resourceAsStream = Test1.class.getClassLoader().getResourceAsStream("config.xml");
        //创建SQLSession对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        //使用工厂创建mapper对象
        SqlSession sqlSession = build.openSession();
        IStudent mapper = sqlSession.getMapper(IStudent.class);
        //调用操作数据库
        Student byId = mapper.findById(1);
        System.out.println(byId);

        System.out.println(mapper.findById(1));
        //释放资源
        sqlSession.close();

    }
}
