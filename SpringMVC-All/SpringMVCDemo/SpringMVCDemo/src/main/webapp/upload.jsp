<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/26
  Time: 4:24 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- enctype 必须设置，POST方式  --%>
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="img" />
        <input type="submit" value="上传">
    </form>

    <img src="${path}" />


<%-- enctype 必须设置，POST方式  --%>
<form action="/file/uploads" method="post" enctype="multipart/form-data">
    file1:<input type="file" name="imgs" />
    file2:<input type="file" name="imgs" />
    file3:<input type="file" name="imgs" />
    <input type="submit" value="上传">
</form>

<c:forEach items="${files}" var="file">
    <img src="${file}" width="300px">
</c:forEach>

<hr/>
    <a href="/file/download/1">1.png</a><br/>
    <a href="/file/download/2">2.png</a><br/>
    <a href="/file/download/3">3.png</a><br/>
</body>
</html>
