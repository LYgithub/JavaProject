<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/5/30
  Time: 5:08 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用JavaBean计算两个数的和</title>
</head>
<body>
<jsp:useBean id="x" class="com.bean.Add" scope="application"/>
<jsp:setProperty name="x" property="date1" value="10"></jsp:setProperty>
<jsp:setProperty name="x" property="date2" value="12"></jsp:setProperty>

<%=x.sum()%>
</body>
</html>
