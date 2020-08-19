package lambda;


/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/08/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class LambdaDemo {
    public static void main(String[] args) {
        test((x, y) -> System.out.println(x+y));
        test((o1,o2)->{
            int x = o1 + o2;
            System.out.println(x);
        });
        test2((x,y)->{
            System.out.println(x);
            System.out.println(y);
            return x;
        },2,3);
        System.out.println();

        test3(()->{
            System.out.println("----");
            System.out.println("====");
        });

        System.out.println(test2((int x, int y)->{
            int sum = x + y;
            return sum;
        },2,3));
        System.out.println(" === 分割线 ===");
        test4((int e) -> 2*e, 3);

    }


    private static void test(MyInterface myInterface){
        myInterface.method(2,1);
    }

    private static int test2(MyInterface2 myInterface2,int x,int y){
        return myInterface2.method(x,y);
    }

    private static void test3(Runnable runnable){
        runnable.run();
    }

    private static int test4(MyInterface3 myInterface3, int x) {
        return myInterface3.method(x);
    }
}

@FunctionalInterface
interface MyInterface{
    public abstract void method(int x,int y);
}

@FunctionalInterface
interface MyInterface2{
    public abstract int method(int x,int y);
}

@FunctionalInterface
interface MyInterface3{
    public abstract int method(int x);
}