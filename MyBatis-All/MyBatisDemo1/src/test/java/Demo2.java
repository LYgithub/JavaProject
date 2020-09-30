import com.item.dao.IUserDao;
import com.item.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo1
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo2 {
    public static void main(String[] args) {
        //读取配置文件
        InputStream resourceAsStream = Demo2.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SQlSeBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        //创建一个实体类
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User(100	,"张S安",new Date(2018,03,8,11,44), "女","北京修正");
        int insert = mapper.insert(user);
        sqlSession.commit();
        System.out.println(insert);
        sqlSession.close();

    }
}
