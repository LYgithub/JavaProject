<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/5/30
  Time: 3:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>复数运算</title>
</head>
<body>
    <form action="PageSum.jsp" method="post">
        请输入第一个复数的实部<input type="text" name="r1"><br>
        请输入第一个参数的虚部<input type="text" name="r2"><br>
        <select name="oper">
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select><br>

        请输入第二个复数的实部<input type="text" name="l1"><br>
        请输入第二个参数的虚部<input type="text" name="l2"><br>
        <input type="submit" value="计算">
    </form>
</body>
</html>
