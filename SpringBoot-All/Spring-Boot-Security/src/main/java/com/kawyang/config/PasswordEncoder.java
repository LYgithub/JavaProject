package com.kawyang.config;



/**
 * @author LiYang
 * @Project Name: Spring-Boot-Security
 * @Package Name: com.kawyang.config
 * Created by MacBook Air on 2020/06/30.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
