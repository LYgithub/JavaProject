package com.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item
 * Created by MacBook Air on 2020/06/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    Long id;
    String name;
}
