<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/5/30
  Time: 4:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>复数计算</title>
</head>
<body>
    <form method="post" action="复数计算Page2.jsp">
        第一个复数的实部<input name="r1" type="text"><br>
        第一个复数的虚部<input name="r2" type="text"><br>
        <select name="pero">
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select>
        第二个复数的实部<input name="l1" type="text"><br>
        第二个复数的虚部<input name="l2" type="text"><br>
        <input type="submit" value="计算">
    </form>
</body>
</html>
