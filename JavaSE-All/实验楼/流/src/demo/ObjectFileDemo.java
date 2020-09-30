package demo;

import java.awt.*;
import java.io.*;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ObjectFileDemo {
    private static final File fPath = new File(System.getProperty("user.dir")+"/流/Object.txt");

    public static void main(String[] args) {
        Point3D point3D = new Point3D(1,2,3,Color.red);
        try{
            point3D.move(1,2,3);
            WriteFile(point3D);
            ReadFile();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static void ReadFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fPath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Point3D point3D;

        int readNumber = objectInputStream.read();
        System.out.println("readNumber = " + readNumber);

        point3D = (Point3D) objectInputStream.readObject();
        point3D.Print();

        fileInputStream.close();
        objectInputStream.close();

    }

    public static void WriteFile(Point3D point3D) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(fPath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(point3D);

        objectOutputStream.close();
        fileOutputStream.close();
    }
}


class Point3D implements Serializable {
    int x,y,z;
    Color color;

    public Point3D(int x, int y, int z, Color color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }

    public void move(int dx,int dy,int dz){
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }
    public void Print(){
        System.out.println("("+x+","+y+","+z+")\t"+"Color:"+color);
    }
}