import com.yang.Connection;
import com.yang.service.LoginService;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  * @author LiYang
 *  * @Project Name: Java-SE
 *  * @Package Name: PACKAGE_NAME
 *  * Created by MacBook Air on 2020/09/10.
 *  * Copyright © 2020 LiYang. All rights reserved.
 */
public class ThreadLocalConnection {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        loginService.login();
    }
}
