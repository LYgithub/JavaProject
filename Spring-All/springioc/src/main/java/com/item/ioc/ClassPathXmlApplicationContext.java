package com.item.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item.ioc
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map<String, Object> ioc = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext(String path) throws Exception {
        SAXReader reader = new SAXReader();
        Document read = reader.read("./src/main/resources/" + path);
        Element rootElement = read.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element element = (Element) iterator.next();
            String id = element.attributeValue("id");
            String className = element.attributeValue("class");

            //通过反射创建对象
            Class aClass = Class.forName(className);
            Constructor constructor = aClass.getConstructor();
            Object o = constructor.newInstance();

            Iterator iterator1 = element.elementIterator();
            while (iterator1.hasNext()){
                Element next =(Element) iterator1.next();
                System.out.println("---------------");
                String name = next.attributeValue("name");
                String value = next.attributeValue("value");

                String ref = next.attributeValue("ref");
                System.out.println(ref);
                //普通赋值
                if(ref == null){
                    String mothedName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    System.out.print(name+ "\t" + value + "\t");
                    Field field = aClass.getDeclaredField(name);
                    System.out.println(field.getType().getName());
                    Method method = aClass.getDeclaredMethod(mothedName, field.getType());
                    Object v = null;
                    if(field.getType().getName() == "int"){
                        v = Integer.parseInt(value);
                    }
                    if(field.getType().getName() == "String"){
                        v = value;
                    }
                    method.invoke(o, v);

                }else{ //注入
                    //直接赋值Bean

                    Object obj1 = ioc.get("Classes");
                    System.out.println(obj1);


                }
            }
            ioc.put(id, o);

        }
        System.out.println("=============");
        System.out.println(ioc);
    }

    public Object getBean(String id) {
        return ioc.get(id);
    }
}
