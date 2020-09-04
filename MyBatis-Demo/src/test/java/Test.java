import com.yang.dao.IStudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentDao studentMapper = (IStudentDao) context.getBean("StudentMapper");
        System.out.println(studentMapper.findById(1).toString());

    }
}
