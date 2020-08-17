#Jsoup

## Jsoup

* Jsoup.parse(new File(path), "utf-8");
* static Document	parse​(String html)
* static Document	parse​(URL url, int timeoutMillis

## Document

获取Element对象

* Elements	getElementsByTag​(String tagName)  标签名
* Elements	getElementsByAttribute​(String key) 属性名
* Elements	getElementsByAttributeValue​(String key, String value)  属性名和值
* Element	getElementById​(String id) 根据id获取

## Element

1. 获取子元素对象
    * Elements	getElementsByTag​(String tagName)  标签名
    * Elements	getElementsByAttribute​(String key) 属性名
    * Elements	getElementsByAttributeValue​(String key, String value)  属性名和值
    * Element	getElementById​(String id) 根据id获取
2. 获取属性
    * String	attr​(String attributeKey)
    
3. 获取文本内容
    * String	text()
        * Gets the combined text of this element and all its children. `纯文本`
    * String	html()	 
        * Retrieves the element's inner HTML.  `标签和文本` 

## Node
    节点对象

# 快捷查询

## selector ： 选择器
    参考Class Selector 中语法
    Elements  select (String cssQuery)	
      Find elements that match the Selector CSS query, with this element as the starting context.

```java
    document.select("Tag");
    document.select("#id");
    document.select("studnet[tag=\"val\"]") //student标签tag属性为val的标签
    document.select("#id > son"); //子标签
```

## XPath ： w3c提供

使用JSoup的XPath 导入 jar包

* JsoupXpath-0.3.2.jar

* commons-lang3-3.1.jar

创建JXDocument对象  

```java
JXDocument jsJxDocument = new JXDocument(document);
jsJxDocument.selN("//student//age");//查询元素
```



   

