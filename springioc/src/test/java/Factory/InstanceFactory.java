package Factory;

import com.item.Car;
import com.item.factory.InstanceCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: Factory
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class InstanceFactory {
    public static void main(String[] args) {
        InstanceCarFactory factory = new InstanceCarFactory();
        System.out.println(factory.getCar(2L));

        ApplicationContext context = new ClassPathXmlApplicationContext("config-factory.xml");
        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);

    }
}
