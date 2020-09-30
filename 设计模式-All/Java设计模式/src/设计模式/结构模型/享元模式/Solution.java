package 设计模式.结构模型.享元模式;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.结构模型.享元模式
 * Created by MacBook Air on 2020/07/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,2, TreeFactory.getTree("杨树","any about 杨树"));
        System.out.println(treeNode.toString());
        TreeNode treeNode2 = new TreeNode(3,2, TreeFactory.getTree("柏树","any about 柏树"));
        System.out.println(treeNode2.toString());
        TreeNode treeNode3 = new TreeNode(5,4,TreeFactory.getTree("柏树","柏树"));
        System.out.println(treeNode3.toString());

    }
}

class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "x=" + x +
                ", y=" + y +
                ", tree=" + tree +
                '}';
    }
}

class TreeFactory {
    static Map<String,Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String any){

        if (!map.containsKey(name)) {
            map.put(name, new Tree(name, any));
        }
        return map.get(name);
    }
}

class Tree{
    private final String name;
    private final String any;

    public Tree(String name, String any) {
        System.out.println("create tree,name:" + name);
        this.name = name;
        this.any = any;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", any='" + any + '\'' +
                '}';
    }
}
