<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/27
  Time: 5:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <form:form method="post" action="/validator/login2" modelAttribute="person2">
        username:<form:input path="username" /><form:errors path="username"/><br>
        password:<form:password path="password" /><form:errors style="color: red" path="password"/><br>
        email:<form:input path="email" /><form:errors path="email" /><br>
        phone:<form:input path="phone" /><form:errors path="phone" /><br>
        <input type="submit" value="login">
    </form:form>
</div>
</body>
</html>
