package liu;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/28.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 */
public class ObjectLiu {
    public static void main(String[] args) {
        objectWrite();
        objectRead();
    }

    /**
     * 反序列化过程
     */
    public static void objectRead() {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/liu/object.txt"));
            Point point = (Point) objectInputStream.readObject();
            System.out.print("读出：");
            point.print();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error1:"+e.toString());
        }
    }

    /**
     * 序列化过程
     */
    private static void objectWrite() {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/liu/object.txt"));
            objectOutputStream.writeObject(new Point(2,3,4));
            System.out.println("写入成功!");
            objectOutputStream.close();
        }catch (IOException e){
            //NotSerializableException 没有序列化异常
            //Serializable
            System.out.println("Error2:"+e.toString());
        }
    }
}
/**
 * 序列化标记型接口
 */
class Point implements Serializable{
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