package com.shiyanlou.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiYang
 * @Project Name: springboot
 * @Package Name: com.shiyanlou.config
 * Created by MacBook Air on 2020/10/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
// @Configuration 表示该类为配置类，
// 该注解可以被 @ComponentScan 扫描到
//@Configuration
public class ServletConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        // 设置 端口 8080
        factory.setPort(8080);
    }
}
