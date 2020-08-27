import com.yang.Man;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/08/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ManFactoryTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man1 = (Man) context.getBean("man1");
        System.out.println(man1.getName());
        Man man0 = (Man) context.getBean("man0");
        System.out.println(man0.getName());
    }
}
