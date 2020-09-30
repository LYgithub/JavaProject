package Good;

import com.kawyang.entity.Good;
import com.kawyang.repository.IGoodRepository;
import com.kawyang.utils.MapperUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Good
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        IGoodRepository mapper = MapperUtil.getMapper("config.xml", IGoodRepository.class);
        List<Good> all = mapper.findAll();
        System.out.println(Arrays.toString(all.toArray()));
        System.out.println(mapper.findById(3));
    }
}
