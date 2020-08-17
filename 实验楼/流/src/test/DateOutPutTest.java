package test;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: test
 * Created by MacBook Air on 2020/02/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class DateOutPutTest {
    public static void main(String[] args) throws IOException {
        //user.dir Project路径
        File file = new File(System.getProperty("user.dir")+"/流/ClassDate.txt");
        if(!file.exists()){
            boolean a = file.createNewFile();
            System.out.println("文件创建成功！"+file+"\t"+a);
        }
        writeData(file);
        readData(file);
        writeDataByte(file);
    }
    public static void writeData(File file) {
        //字节流
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            dataOut.writeInt(20201234);
            dataOut.writeUTF("张良");
            dataOut.writeInt(90);
            dataOut.writeFloat(31);
            dataOut.writeDouble(98.5);
            dataOut.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static void readData(File file) throws FileNotFoundException {
        DataInputStream dRead = new DataInputStream(new FileInputStream(file));
        try{
            boolean sign = true;
            //while (sign){
                System.out.print(dRead.readInt()+"\t");
                System.out.print(dRead.readUTF()+"\t");
                System.out.print(dRead.readInt()+"\t");
                System.out.print(dRead.readFloat()+"\t");
                System.out.println(dRead.readDouble());
            //}
            dRead.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeDataByte(File file){
        //字符流
        try{
            //转换器
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s = bufferedReader.readLine();
            System.out.println(s);
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(file));
            dOut.writeUTF(s);
            dOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
