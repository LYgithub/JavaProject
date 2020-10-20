package com.shiyanlou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LiYang
 * @Project Name: springboot
 * @Package Name: com.shiyanlou.config
 * Created by MacBook Air on 2020/10/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将 /upload/ 路径 映射为 /**
        registry.addResourceHandler("/**")
                .addResourceLocations(
                        "classpath:/static/upload/",
                        "classpath:/static/css/",
                        "classpath:/static/");
    }
}
