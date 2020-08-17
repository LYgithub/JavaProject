package com.item.ioc;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item.ioc
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface ApplicationContext {
    Object getBean(String id);
}
