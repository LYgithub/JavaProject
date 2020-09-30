<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/9/15
  Time: 9:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <% request.setAttribute("APP_Path" ,request.getContextPath()); %>
</head>
<body>
    <div>
        <form method="post" action="${APP_Path}/admin/index.jsp" >
            <input name="username" type="text" value="username" /><br/>
            <input name="password" type="password" value="password" /><br/>
            <input type="submit" value="submit" />
        </form>
    </div>
</body>
</html>
