
import com.yang.entity.Student;
import com.yang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {


    @org.junit.jupiter.api.Test
    public void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        StudentService bean = context.getBean(StudentService.class);
        // 1、 更新数据
        bean.update(new Student(1, "KawYang", 1));
        // 2、 查看更新
        //System.out.println(Arrays.toString(bean.findAll().toArray()));
        // 3、 登陆测试
        bean.login(new Student(1,"yang", 1));
        // 4、 查看数据
        Student byId = bean.findById(1);
        if("KawYang".equals(byId.getName())){
            System.out.println("================  事务处理成功！！  ===============");
        }else{
            System.out.println("================  事务处理失败！！  ===============");

        }


    }
}
