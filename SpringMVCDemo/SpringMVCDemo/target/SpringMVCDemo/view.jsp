<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/26
  Time: 9:05 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.user}
<hr/>
${sessionScope.user}
<hr/>
${applicationScope.user}
</body>
</html>
