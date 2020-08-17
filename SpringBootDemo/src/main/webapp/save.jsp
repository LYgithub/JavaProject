<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/28
  Time: 10:30 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/spring/save" method="post" >
        id:<input type="text" name="id" value="${student.id}"/><br/>
        name:<input type="text" name="name" value="${student.name}" /><br/>
        age:<input type="text" name="age"  value="${student.age}"/><br/>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
