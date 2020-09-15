package com.kawyang.test;





import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SSM-CRUD
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/07/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MBJTest {
    public static void main(String[] args) {
        try{
            List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
            File configFile = new File("mdg.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
