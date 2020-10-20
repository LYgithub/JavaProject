package com.shiyanlou;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LiYang
 * @Project Name: springboot
 * @Package Name: com.shiyanlou
 * Created by MacBook Air on 2020/10/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */

// @SpringBootApplication 注解相当于同时使用
// @EnableAutoConfiguration、@ComponentScan、@Configurations 三个注解
// @EnableAutoConfiguration 用于打开 Spring Boot 自动配置，而其余注解为 Spring 注解，这里不再赘述
@SpringBootApplication

@ImportResource(value = "classpath:config.xml")
public class SpringbootApplication {

    //@Configuration
    static class WebDataConfig implements WebMvcConfigurer{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/static/css/");
        }
    }



    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
