<%@ page import="com.bean.Add" %><%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/5/30
  Time: 4:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>和</title>
</head>
<body>
<% request.setCharacterEncoding("utf8");%>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
    Add add = new Add();

    String s1 = request.getParameter("date1");
    String s2 = request.getParameter("date2");
    int x = Integer.parseInt(s1);
    int y = Integer.parseInt(s2);
    add.setDate1(x);
    add.setDate2(y);
%>
"${APP_PATH}"
<%= add.getDate1()%>+<%=add.getDate2()%>=<%=add.sum()%>
</body>
</html>
