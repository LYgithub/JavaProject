package com.kawyang.validator;

import com.kawyang.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.validator
 * Created by MacBook Air on 2020/06/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class AccountValidator implements Validator {

    @Override
    //判断是否进行验证
    public boolean supports(Class<?> aClass) {
        System.out.println("验证");
        return Account.class.equals(aClass);
    }

    @Override
    //进行数据校验
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "name", null, "不能为空");
        ValidationUtils.rejectIfEmpty(errors, "password", null, "不能为空");
    }
}
