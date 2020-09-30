<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h3>登录成功</h3>
<% String userName = request.getParameter("userName"); %>
<h4>欢迎${requestScope.keySet()}</h4><br>
<h4>欢迎<%=userName%></h4>
<form id="form1" action="login" method="post">
    用户名：<input type="text" name="userName" id="userName" /><br>
    密码： <input type="password" name="passWord" value="123" id="password" />
    <input type="submit" value="提交"/>
</form>
</body>
</html>