package demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileInSystemDemo {
    static final String fPath = System.getProperty("user.dir");
    public static void main(String[] args) {
        try {
            //复制
            copFile();

            //移动
            Path path1 = Paths.get(fPath + "/2.txt");
            Path path2 = Paths.get(fPath + "/流/2.txt");
            moveFile(path1, path2);

            //重命名
            path1 = Paths.get(fPath + "/流/2.txt");
            path2 = Paths.get(fPath + "/流/3.txt");
            moveFile(path1, path2);

            //删除
            deleteFile(path2.toString());

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static void copFile(){
        try{
            Path path1 = Paths.get(System.getProperty("user.dir")+"/流/1.txt");
            Path path2 = Paths.get(System.getProperty("user.dir")+"/2.txt");
            Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copy:"+path1+"->"+path2);
        } catch (IOException e) {
            System.out.println("Error:"+e.toString());
        }
    }

    public static void moveFile(Path path1,Path path2){
        try {
            Files.move(path1,path2, StandardCopyOption.ATOMIC_MOVE);
            System.out.println("Move:"+path1+"->"+path2);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFile(String path1){
        //Files.delete(path1);
        //Files.deleteIfExists(Paths.get("/home/project/3.txt")
        File file = new File(path1);
        boolean b = file.delete();
        System.out.println("Delete:"+b+"\n\tPath:"+path1);

    }
}
