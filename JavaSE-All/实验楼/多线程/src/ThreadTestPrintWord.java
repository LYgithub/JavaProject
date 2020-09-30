/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ThreadTestPrintWord {
    public static void main(String[] args) {
        Printf printf = new Printf();
        printf.run();
        printf.run();
        printf.run();
    }
}
class Printf implements Runnable{

    @Override
    public void run() {
        char []a = {'A','B','C'};
        for (char c : a) {
            System.out.println(c);
        }
    }
}
