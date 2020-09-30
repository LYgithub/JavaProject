package com.yang.util;

import com.yang.Connection;


/**
 * @author LiYang
 * @Project Name: Java-SE
 * @Package Name: com.yang.util
 * Created by MacBook Air on 2020/09/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ConnectionUtils {
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    public static Connection getThreadLocal() {

        Connection connection = THREAD_LOCAL.get();
        if(connection == null){
            THREAD_LOCAL.set(new Connection());
        }
        return THREAD_LOCAL.get();

    }
}
