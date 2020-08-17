package Classes;

import com.kawyang.entity.ClassesStu;
import com.kawyang.repository.IClassesStuRepository;
import com.kawyang.utils.MapperUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Classes
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        IClassesStuRepository mapper =
                MapperUtil.getMapper("config.xml", IClassesStuRepository.class);
        List<ClassesStu> all = mapper.findAll();
        System.out.println(Arrays.toString(all.toArray()));

        ClassesStu byId = mapper.findById(3);
        System.out.println(byId);
    }
}
