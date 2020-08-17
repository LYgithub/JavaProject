package 设计模式.单例模式;

/**
 * 饿汉式
 * 在实例化加载类时创建类对象
 * @author LiYang
 */
public class Single {
    /**
     * 私有化构造函数
     */
    private Single(){
        System.out.println("Single 创建！");
    }

    /**
     * 私有静态对象
     */
    private static Single single = new Single();

    /**
     * 使用对象
      * @return 静态类对象
     */
    public static Single getInstance(){
       return single;
    }

}
