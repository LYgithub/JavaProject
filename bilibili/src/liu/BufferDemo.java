package liu;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class BufferDemo {
    public static void main(String[] args) {
        buffOutput();
        buffInput();

        buffWrite();
        buffRead();
    }

    private static void buffRead() {
        try{
            FileReader read = new FileReader("src/liu/buffer.txt");
            BufferedReader bread = new BufferedReader(read);
            System.out.println("读取一行：" + bread.readLine());
            int x ;
            while ((x = bread.read())!= -1){
                System.out.print((char)x);
            }
            String s ;
            while ((s = bread.readLine()) != null){
                System.out.println(s);
            }
            bread.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

    private static void buffWrite() {
        try{
            FileWriter fileWriter = new FileWriter("src/liu/buffer.txt");
            BufferedWriter bWriter =  new BufferedWriter(fileWriter);
            for (int i = 0; i < 3; i++) {
                bWriter.write("BufferedWriter");
                bWriter.newLine();
            }
            bWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private static void buffInput() {
        try(FileInputStream fin = new FileInputStream("src/liu/buffer.txt"); BufferedInputStream bin = new BufferedInputStream(fin)){
            int len ;
            while ((len = bin.read()) != -1){
                System.out.print(len + "\t");
            }
            System.out.println();

            byte [] arr = new byte[1024];
            while ((len = bin.read(arr))!= -1){
                System.out.println(new String(arr,0,len));
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void buffOutput() {
        try(FileOutputStream file = new FileOutputStream("src/liu/buffer.txt");BufferedOutputStream out = new BufferedOutputStream(file)) {
            out.write("缓冲区写入".getBytes());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
