<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/27
  Time: 4:08 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<div>
    <form:form action="/validator/login" method="post" modelAttribute="account">
        Name:<form:input path="name" /><form:errors path="name" />
        Password:<form:password path="password" /><form:errors path="password"/>
        <input type="submit" value="提交" />
    </form:form>
</div>
</body>
</html>
