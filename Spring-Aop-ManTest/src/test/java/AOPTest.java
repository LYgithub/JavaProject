import com.yang.Man;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/08/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class AOPTest {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man civilian = (Man) applicationContext.getBean("civilian");
        civilian.qq();
        Thread.sleep(1000);
        civilian.mm();
    }
}
