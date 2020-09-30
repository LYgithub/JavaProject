<%@ page import="com.bean.Add" %>
<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>计算结果</title>
</head>
<body>
<%
    String s1 = request.getParameter("data1");
    Add add = new Add();
    add.setData1(Integer.parseInt(request.getParameter("data1")));
    add.setData2(Integer.parseInt(request.getParameter("data2")));
    String s2 = request.getParameter("data2");
%>
<h2>
    <%=s1%>+<%=s2%>=<%=add.sum()%>
</h2>
<br/>
<hr/>
<h4>使用jsp:userBean计算</h4>
    <jsp:useBean id="test" class="com.bean.Add" />
    <jsp:setProperty name="test" property="data1" value="-1"/>
    <jsp:setProperty name="test" property="data1" value="-2"/>
<h2><%=test.getData1()%>+<%=test.getData2()%>=<%=test.sum()%></h2>
<hr/>

<form name="form1" method="post" action="hello">
    输入第一个数：<input type="text" name="data1" /><br>
    输入第二个数：<input type="text" name="data2" /><br>
    <input type="submit" value="计算"><br>
</form>
</body>
</html>