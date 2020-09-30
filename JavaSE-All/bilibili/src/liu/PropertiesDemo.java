package liu;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class PropertiesDemo {
    public static void main(String[] args)  {
        show01();
        show02();
        show03();
    }

    /**
     * Load()
     */
    private static void show03(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/liu/prop2.txt"));
            Set<String> set = properties.stringPropertyNames();
            for (String Key : set) {
                System.out.println(Key + "=" + properties.getProperty(Key));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(FileReader fileReader =  new FileReader("src/liu/properties.txt")){
            properties.load(fileReader);

            Set<String> set = properties.stringPropertyNames();
            for (String Key : set) {
                System.out.println(Key + "=" + properties.getProperty(Key));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * 临时数据写入硬盘
     * public void store​(OutputStream out,String comments)  //不能写入中文   comments 解释文件的作用(不能使用中文) Unicode编码 一般用空字符串
     * public void store​(Writer writer,String comments)     //可以写入中文
     */
    private static void show02() {
        Properties prop = new Properties();
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","178");

        //prop.put(1,true);

        try(FileWriter fileWriter = new FileWriter("src/liu/Properties.txt")){
            prop.store(fileWriter,"");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream("src/liu/prop2.txt")){
            prop.store(fileOutputStream,"noting");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *  使用 Properties 集合存储数据，遍历取出 Properties 中的数据
     *  public Object setProperty​(String key,String value)
     *  public String getProperty​(String key)      //根据Key 获取值
     *  public Set<String> stringPropertyNames()  //返回键值对
     */
    private static void show01() {
        Properties prop = new Properties();
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","178");
        prop.put(1,true);

        Set<String> set = prop.stringPropertyNames();
        System.out.println(Arrays.toString(set.toArray()));
        for (String key : set) {
            System.out.println(key +  "=" + prop.getProperty(key));
        }
        System.out.println(prop.get(1));
    }


}
