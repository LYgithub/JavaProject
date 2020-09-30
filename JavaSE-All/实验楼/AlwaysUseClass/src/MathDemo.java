/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println("绝对值："+Math.abs(-12));
        System.out.println("随机数"+Math.random());
        System.out.println("向上取整"+Math.ceil(12.4));
        //floor向下
        //arg 为 double 时返回 long，为 float 时返回 int	返回最接近arg的整数值
        System.out.println(Math.round(12.4));

        System.out.println("sin30 = " + Math.sin(Math.PI / 6));
        // 计算30°的正弦值，参数是用弧度表示的角，即π的六分之一
        System.out.println("cos30 = " + Math.cos(Math.PI / 6));
        // 计算30°的余弦值，这些计算三角函数的方法，其参数和返回值的类型都为double
        System.out.println("tan30 = " + Math.tan(Math.PI / 6));
        // 计算30°的正切值
    }
}
