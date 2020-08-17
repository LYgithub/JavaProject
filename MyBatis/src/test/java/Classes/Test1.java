package Classes;

import com.kawyang.model.Classes;
import com.kawyang.repository.IClass;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: Classes
 * Created by MacBook Air on 2020/06/23.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test1 {
    public static void main(String[] args) {
        //读取配置文件
        InputStream resourceAsStream = Test1.class.getClassLoader().getResourceAsStream("config.xml");
        //创建工厂
        SqlSessionFactoryBuilder builder =  new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        IClass mapper = sqlSession.getMapper(IClass.class);
        List<Classes> all = mapper.findAll();
        for (Classes c: all) {

            System.out.println(c);
        }

        printLine();

        Classes classes = new Classes(3, "四班");
        mapper.insertClass(classes);
        //提交事务
        sqlSession.commit();
        printLine();

        Classes byId = mapper.findById(3);
        System.out.println(byId);
        printLine();

        classes.setName("三班");
        mapper.updateClass(classes);
        printLine();

        byId = mapper.findById(3);
        System.out.println(byId);

        printLine();
        mapper.deleteById(3);
        printLine();

        byId = mapper.findById(3);
        System.out.println(byId);

        //释放资源
        sqlSession.close();

    }

    private static void printLine(){
        System.out.println("----------------------------------------");
    }
}
