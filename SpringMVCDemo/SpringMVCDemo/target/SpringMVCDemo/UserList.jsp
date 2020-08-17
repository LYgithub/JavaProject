<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/25
  Time: 3:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/data/list">
    ID1<input type="text" name="users[0].id"><br/>
    name1<input type="text" name="users[0].name"><br/>
    ID2<input type="text" name="users[1].id"><br/>
    name2<input type="text" name="users[1].name"><br/>
    ID3<input type="text" name="users[2].id"><br/>
    name3<input type="text" name="users[2].name"><br/>
    ID4<input type="text" name="users[3].id"><br/>
    name4<input type="text" name="users[3].name"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
