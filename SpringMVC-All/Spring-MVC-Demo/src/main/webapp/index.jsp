<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
    <% pageContext.setAttribute("App_Path",request.getContextPath()); %>
</head>
<body>
    <form action="${App_Path}/demo" method="post">
        <input type="text" name="name">
        <input type="submit" value="登陆">
    </form>
</body>
</html>

