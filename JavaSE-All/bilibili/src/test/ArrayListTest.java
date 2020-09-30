package test;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: test
 * Created by MacBook Air on 2020/02/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */

import java.io.*;
import java.util.ArrayList;

/**
          1. 定义一个存储Point对象的ArrayList集合
          2. 往List中进行存储Point对象
          3. 创建一个序列化流 ObjectOutputStream 对象
          4. 写入（WriteObject）
          5. 创建反序列化对象
          6. 读出来 （ReadObject）
          7. 把Object类型的集合转化成 ArrayList集合
          8. 遍历
          9. 释放资源
 * @author LiYang
 */
public class ArrayListTest {
    public static void main(String[] args) {
        write();
        read();
    }

    public static void read() {

        try{

            // 对象输入输出流
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/test/object.txt"));
            Object o = objectInputStream.readObject();
            ArrayList<Point> list = (ArrayList<Point>)o;
            //for (Point point : list) {
            //    point.print();
            //}


            // lambda 简化
            // :: 表示引用
            list.forEach(Point::print);

            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error:" + e.toString());
        }
    }

    private static void write() {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Point(1*i,2*i,3*i));
        }
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/test/object.txt"));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        }catch (IOException e){
            System.out.println("Error:"+e.toString());
        }
    }
}
/**
 * 序列化标记型接口
 */
class Point implements Serializable {
    static final long serialVersionUID = 42L;
    private int x;
    private static int y;
    transient int z;

    public Point(int x, int y,int z) {
        this.x = x;
        Point.y = y;
        this.z = z;
    }

    public void print(){
        System.out.println("(" +x+","+y+","+z+")");
    }
}