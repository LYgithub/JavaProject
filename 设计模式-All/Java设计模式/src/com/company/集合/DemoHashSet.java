package com.company.集合;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author LiYang
 * HashSet
 * Set : 无序， 不可重复
 * HashSet : 按照Hash算法进行存储
 */
public class DemoHashSet {
    public static void main(String[] args) {
        DemoHashSet();
        DemoTreeSet();
    }

    /**
     * HashSet : 按照 Hash算法进行排序
     */
    public static void DemoHashSet(){
        //        Set<String> list = new HashSet<String>(); 保存元素类型
        Set set = new HashSet();
        //        Set list2 = new HashSet<String>();
        set.add("String");
        set.add(12);
        set.add(12.3);
        set.add(null);
        System.out.println(set);

        /**
         * 迭代器方法遍历
         */
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=======");

        /**
         * for - each 遍历
         */
        for ( Object obj : set){
            System.out.println(obj);
        }

        System.out.println(set.contains("12"));
    }

    /**
     * TreeSet : 有序的 Set 集合
     */
    public static void DemoTreeSet(){
        Set set = new TreeSet();
        set.add(2);
        set.add(123);
        /* 含有相同元素不添加 */
        set.add(2);
        System.out.println(set);
    }
}
