<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/25
  Time: 10:29 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hello/save" method="post">
    id<input type="text" name="id" />
    name<input type="text" name="name">
<%--  级联操作 --%>
    address<input type="text" name="address.value">
    <input type="submit" value="提交">
</form>
</body>
</html>
