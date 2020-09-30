import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class SystemDemo {
    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 11};
        int[] b = {1, 2, 3, 4, 5, 6};
        //从数组a的第二个元素开始，复制到b数组的第三个位置 复制的元素长度为3
        System.arraycopy(a,1,b,2,3);
        System.out.println(Arrays.toString(b));
        System.out.println("时间：" + System.currentTimeMillis());
        System.out.println("Java版本" + System.getProperty("java.version"));
        System.out.println("Java安装目录：" + System.getProperty("java.home"));
        //垃圾回收集
        System.gc();
        System.exit(0);
    }
}
