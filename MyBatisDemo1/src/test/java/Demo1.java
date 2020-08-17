import com.item.dao.IUserDao;
import com.item.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.security.util.Resources;

import java.io.InputStream;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo1
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/11.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo1 {
    public static void main(String[] args) {
        //1. 读取配置文件
        InputStream in = Demo1.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3. 使用工厂生产SQLSession对象
        SqlSession session = factory.openSession();
        //4. 使用SQLSession创建Dao接口代理对象
        IUserDao mapper = session.getMapper(IUserDao.class);
        //5. 使用代理对象执行方法
        List<User> all = mapper.findAll();
        for(User user : all){
            System.out.println(user);
        }
        System.out.println("----------");
        //5. 使用代理对象执行方法
        List<User> all1 = mapper.findSom();
        for(User user : all1){
            System.out.println(user);
        }
        //6. 释放资源
        session.close();
    }
}
