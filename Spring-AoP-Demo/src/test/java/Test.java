import com.yang.test.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 *@Project Name: Spring-AoP-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo = ((Demo) applicationContext.getBean("demo"));

        demo.method1("参数1",2);
    }
}
