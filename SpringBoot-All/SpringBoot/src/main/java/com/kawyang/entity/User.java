package com.kawyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(message = "id不能为空")
    private long id;
    @NotEmpty(message = "name不能为空")
    @Length(min = 2,message = "名字最小长度为2")
    private String name;
    @Min(value = 16, message = "年龄必须大于16")
    private int age;
}
