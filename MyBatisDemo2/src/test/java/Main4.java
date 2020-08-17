import com.item.entity.Student;
import com.item.repository.IStudent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main4 {
    public static void main(String[] args) {
        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        //一级缓存： 同一个SQLsession
        IStudent mapper = sqlSession.getMapper(IStudent.class);

        Student byId = mapper.findById(2);
        System.out.println(byId);
        IStudent mapper1 = sqlSession.getMapper(IStudent.class);
        Student byId1 = mapper1.findById(2);
        System.out.println(byId1);

        // 二级缓存
        sqlSession.close();

        sqlSession = build.openSession();
        IStudent mapper2 = sqlSession.getMapper(IStudent.class);
        Student byId2 = mapper2.findById(2);
        System.out.println(byId2);
        sqlSession.close();

    }
}

