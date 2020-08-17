import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo1
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo3 {
    public static void main(String[] args) {
        InputStream resourceAsStream = Demo3.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        String statement = "com.item.dao.IUserDao.findAll";
        sqlSession.select(statement,null, null);

    }
}
