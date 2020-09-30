<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/5/30
  Time: 4:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算两个数的和</title>
</head>
<body>
<form method="post" action="sum2.jsp">
    <input name="date1" type="text"> <br/>
    <input name="date2" type="text"> <br/>
    <input type="submit" value="计算">
</form>
<form method="post" action="Show.jsp">
    <input name="date1" type="text"> <br/>
    <input name="date2" type="text"> <br/>
    <input type="submit" value="计算Show">
</form>
</body>
</html>
