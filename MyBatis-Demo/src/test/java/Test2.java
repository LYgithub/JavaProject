import com.yang.dao.IStudentDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test2 {
    public static void main(String[] args) {
        InputStream in = Test2.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(in);
        SqlSession sqlSession = build.openSession();
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        System.out.println(mapper.findById(1).toString());
    }
}
