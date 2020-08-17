<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/27
  Time: 4:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h1>Welcome ${requestScope.account.name}</h1>

<h1>Welcome ${requestScope.person2.username}</h1>
<h1>Welcome ${requestScope.p.username}</h1>
<h2>${requestScope.p}</h2>
</body>
</html>
