package com.kawyang.singleton.lazysingleton;

/**
 * @author LiYang
 *
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}

    public  static LazySingleton getInstance(){
        if(instance == null){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

    public void print(){
        System.out.println(instance);
    }
}
