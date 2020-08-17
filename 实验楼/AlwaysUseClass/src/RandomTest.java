import java.util.Random;
import java.util.Scanner;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class RandomTest {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int m = reader.nextInt();
        int n = reader.nextInt();
        Random random = new Random();
        System.out.println(random.nextInt(n-m+1)+m);

    }
}
