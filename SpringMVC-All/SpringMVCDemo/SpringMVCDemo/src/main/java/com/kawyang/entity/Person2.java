package com.kawyang.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
public class Person2 {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @Size(min = 5, max=16, message = "密码位数在5-16位")
    private String password;

    @Email(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",
            message = "请输入正确的邮箱格mr式")
    private String email;

    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",
            message = "请输入正确的电话")
    private String phone;
}
