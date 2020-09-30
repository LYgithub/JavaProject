package Good;

import com.kawyang.entity.Good;
import com.kawyang.repository.IGoodRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Good
 * Created by MacBook Air on 2020/07/06.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FindCache1 {
    public static void main(String[] args) {
        InputStream resourceAsStream = FindCache1.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IGoodRepository mapper = sqlSession.getMapper(IGoodRepository.class);
        Good goodById = mapper.findGoodById(2);
        System.out.println(goodById.toString());
        //关闭一级缓存
        sqlSession.close();

        SqlSession sqlSession1 = build.openSession();
        IGoodRepository mapper1 = sqlSession1.getMapper(IGoodRepository.class);
        Good goodById1 = mapper1.findGoodById(2);
        System.out.println(goodById1);
    }
}
