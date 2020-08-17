package com.kawyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiYang
 * @Project Name: SpringBaties
 * @Package Name: com.kawyang
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SpringBootApplication
@MapperScan("com.kawyang.repository")
public class Main {
    /** Spring Boot 主程序 */
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
