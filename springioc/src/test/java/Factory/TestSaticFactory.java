package Factory;

import com.item.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class TestSaticFactory {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("config-factory.xml");
            Car car =(Car) context.getBean("car");
            System.out.println(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
