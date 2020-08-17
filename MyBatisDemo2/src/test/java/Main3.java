import com.item.entity.Consumer;
import com.item.entity.Good;
import com.item.repository.IConsumer;
import com.item.repository.IGood;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/14.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 * 数据库多对多练习
 *
 * 一个消费者可以购买多个商品
 * 一个商品也可以被多个消费者购买
 */
public class Main3 {

    public static void main(String[] args) {
        InputStream resourceAsStream = Main3.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = builder.build(resourceAsStream).openSession();
        IGood mapper = sqlSession.getMapper(IGood.class);
        List<Good> all = mapper.findAll();
        for (Good good :
                all) {
            System.out.println(good);
        }

        IConsumer mapper1 = sqlSession.getMapper(IConsumer.class);
        List<Consumer> all1 = mapper1.findAll();
        for (Consumer consumer : all1) {
            System.out.println(consumer);
        }

        sqlSession.close();
    }
}
