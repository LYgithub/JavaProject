import com.yang.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/08/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class PersonTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person.toString());

        Person person1 = ((Person) context.getBean("person"));
        System.out.println(person1.toString());
    }
}
