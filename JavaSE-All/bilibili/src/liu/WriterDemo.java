package liu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        write();
        //自动释放流对象 优化 JDK 7
        write1();
        //自动释放流对象 优化 JDK 9
        write2();
    }

    /**
     * Write Demo
     */
    private static void write() {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("src/liu/c.txt");
            fileWriter.write("KawYang程序员",7,3);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(fileWriter != null){
                try{

                    fileWriter.close();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * JDK 7
     * try(...;...){
     * }catch(){
     * }
     */
    private static void write1() {

        try(FileWriter fileWriter = new FileWriter("src/liu/c.txt");
            FileReader fileReader = new FileReader("src/liu/c.txt")){

            fileWriter.write(97);
            char[] arr = {'a','\n','b','\n','c','好'};
            fileWriter.write(arr);
            fileWriter.write(arr,1,5);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * JDK 9
     * A a = new A();//依然存在异常
     * B b = new B();
     * try(a;b){
     * }catch(){
     * }
     */
    private static void write2() throws IOException {
        FileWriter fileWriter = new FileWriter("src/liu/c.txt");
        FileReader fileReader = new FileReader("src/liu/c.txt");
        try(fileWriter;fileReader){
            /**
             * 字符输出流写数据的其他方法
             */
            char[] arr = {'a','\n','b','\n','c','好'};
            fileWriter.write(arr);

            fileWriter.write(arr,1,5);

            fileWriter.write("KawYang程序员",7,3);


        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
