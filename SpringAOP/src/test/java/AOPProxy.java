import com.item.util.Cal;
import com.item.util.impl.CalImpl;
import com.item.util.impl.CalImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: SpringAOP
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 *
 */

public class AOPProxy {
    public static void main(String[] args) {
        CalImpl2 calImpl2 = new CalImpl2();
        System.out.println(calImpl2.add(1, 2));

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-config.xml");
        Cal calImpl21 =(Cal) applicationContext.getBean("test");
        System.out.println(calImpl21.add(1, 33));
    }
}
