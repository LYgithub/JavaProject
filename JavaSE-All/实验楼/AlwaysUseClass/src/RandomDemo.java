import java.util.Random;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt());
        //[0,12)
        System.out.println(random.nextInt(12));
        //生成 [0,100]
        System.out.println(random.nextInt(100 + 1));
        //[40,100]
        System.out.println((random.nextInt(61) + 40));
        //随机生成一个整数 long范围
        System.out.print(random.nextLong());
        //生成[0,1.0)范围的float型小数
        System.out.println(random.nextFloat());
        //生成[0,1.0)范围的double型小数
        System.out.println(random.nextDouble());

    }
}
