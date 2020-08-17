package Consumer;

import com.kawyang.entity.Consumer;
import com.kawyang.repository.IConsumerRepository;
import com.kawyang.utils.MapperUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: Consumer
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        IConsumerRepository mapper = MapperUtil.getMapper("config.xml", IConsumerRepository.class);
        List<Consumer> all = mapper.findAll();
        System.out.println(Arrays.toString(all.toArray()));

        //只能是2  其他都含有多条数据
        System.out.println(mapper.findById(2));
    }
}
