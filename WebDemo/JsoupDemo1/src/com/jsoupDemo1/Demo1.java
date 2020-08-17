package com.jsoupDemo1;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author LiYang
 * jsoup 入门
 *
 * jsoup ：工具类，可以解析html和xml文档，返回Document对象
 * Document：文档对象。返回内存中的dom树
 * Elements：元素对象的结合，可当做ArrayList<Element> 来使用
 * Element ： 元素对对象
 * Node ： 节点对象
 *
 */
public class Demo1 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {

//        jsoup();
        Xpath();

    }
    public static void jsoup() throws IOException {
        //导入jar包
        //获取Document对象
        //1. 根据文档获取
        // 1.1 获取path
        String path = Demo1.class.getClassLoader().getResource("Student.xml").getPath();
        // 1.2 解析xml进内存

        Document document = Jsoup.parse(new File(path), "utf-8");

        //3. 获取对象
        Elements name = document.getElementsByTag("name");
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id+"\n --------");
        System.out.println(document.getElementsByAttributeValue("id", "student1")+"\n --------");

        System.out.println("document.getElementsByTag('student').get(0).getElementsByTag('name'):" + document.getElementsByTag("student").get(0).getElementsByTag("name").text());

        document.select("Tag");
        document.select("#id");

        System.out.println(name.get(1).text());
        System.out.println("============");
        System.out.println(document.getElementById("student1"));
    }

    public static void Xpath() throws XpathSyntaxErrorException, IOException {
        String path = Demo1.class.getClassLoader().getResource("Student.xml").getPath();
        System.out.println(path);
        Document document = Jsoup.parse(new File(path), "utf-8");
        JXDocument jsJxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jsJxDocument.selN("//student//age");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

    }
}
