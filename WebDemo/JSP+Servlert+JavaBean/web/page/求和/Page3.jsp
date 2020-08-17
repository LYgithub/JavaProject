<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/4
  Time: 10:47 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用Servlet计算</title>
</head>
<body>
<h2>
    使用Servlet计算<br/>
    <%=request.getParameter("data1")%>+<%=request.getParameter("data2")%>=<%=request.getAttribute("sum")%>
</h2>
</body>
</html>
