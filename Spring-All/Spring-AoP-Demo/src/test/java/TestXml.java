import com.yang.test.Demo;
import com.yang.test.Demo2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 *@Project Name: Spring-AoP-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class TestXml {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo = ((Demo) applicationContext.getBean("demo"));
        demo.method1("参数1",2);
        System.out.println("========= 环绕增强 ========");
        Demo2 demo2 = ((Demo2) applicationContext.getBean("demo2"));
        demo2.method1("参数1",2);
    }
}
