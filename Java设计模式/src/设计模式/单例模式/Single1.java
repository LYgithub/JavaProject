package 设计模式.单例模式;
/**
 * 懒汉式单例模式
 * 在使用类对象时创建
 * @author LiYang
 */
public class Single1 {
    private Single1(){
        //类的构造函数
        System.out.println("Single1 创建！");
    }

    /**
     * 静态类成员变量
     */
    private static Single1 single1 = null;

    /**
     * 获取对象
     * @return 类成员变量
     */
    public static Single1 getInstance(){
        if( single1 == null){
            System.out.println("Single1 为null！");
            single1 = new Single1();
        }
        return single1;
    }


    /**
     * 线程安全的单例设计模式 ， 懒汉式
     * @return
     */
    public static Single1 getInstance1(){
        if(single1 == null){
            synchronized (single1){
                if(single1 == null){
                    single1 = new Single1();
                }
            }
        }
        return single1;
    }
}
