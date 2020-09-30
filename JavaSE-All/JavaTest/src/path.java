import javax.swing.*;

/**
 * @author Mac
 * @Project Name: JavaTest
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/07.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class path {
    public static void main(String[] args) {
        //获取执行程序的当前路径
        String file = System.getProperty("user.dir");
        System.out.println(file);
        ImageIcon icon = new ImageIcon(file+"/image.1");
        System.out.println(icon);
    }
}
