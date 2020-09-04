import com.yang.test.Demo3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test2Annotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo3 demo = applicationContext.getBean(Demo3.class);
        demo.method("参数1", 2);
        System.out.println("=====  Returning ====");
        demo.method2("arg1", 3);
    }
}
