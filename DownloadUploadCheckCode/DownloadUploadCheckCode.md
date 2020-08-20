# 转发和重定向的区别

| 区别   | 转发 **forword()**                                           | 重定向 **sendredirect()**                     |
| ------ | :----------------------------------------------------------- | --------------------------------------------- |
| 定义   | 由服务器端进行跳转                                               | 客户端进行跳转                                |
| 请求数 | 一次                                                           | 两次                                          |
| 格式   | req.getRequestDispatcher("responseDemo3").forward(req, resp); | resp.sendRedirect("/HomeWork/responseDemo2"); |
| 地址栏 | 不变                                                         | 改变，可以跳转到服务器外的网站                |
| 数据   | 请求域中数据不会丢失                                         | 请求域中数据丢失                              |


# doPost & doGet 请求

```java
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo3...");
        // 默认 ISO-8859 TomCat
        resp.setCharacterEncoding("utf8");

        //告诉浏览器编码 包含设置 TomCat
        resp.setHeader("Content-type", "text/html;charset=utf-8");

        //简单方式
        resp.setContentType("text/html;charset=utf-8");

        //字节输出流
        PrintWriter writer = resp.getWriter();
        writer.write("Hello Response");
        //window  JBK， JB132
        writer.write("你好！！");

        // 字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.setContentType("text/html;charset=utf-8");
        outputStream.write("hello".getBytes(StandardCharsets.UTF_8));
        outputStream.write("你好".getBytes("utf-8"));

    }

```

# 文件上传下载

```java
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数
        String filename = request.getParameter("filename");
        
        //2.使用字节输入流加载进内存
        //2.1 找到真实路径
        ServletContext servletContext = this.getServletContext();
        String path = servletContext.getRealPath("/img/" + filename);
        //2.2 关联字节流
        FileInputStream fileInputStream = new FileInputStream(path);
        //3. 设置response的响应头
        //MIME 类型
        String mimeType = servletContext.getMimeType(path);
        response.setHeader("content-type", mimeType);
        //设置打开方式 打开方式
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        
        // 4. 输出到网络
        ServletOutputStream outputStream = response.getOutputStream();
        byte[]buff = new byte[1024 * 8];
        int len = 0;
        while((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff, 0, len);
        }
        outputStream.shu
        fileInputStream.close();

    }
```


# 参考内容

[转发和重定向的区别和使用](https://blog.csdn.net/weixin_40001125/article/details/88663468)