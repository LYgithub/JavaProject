<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/28
  Time: 10:24 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        /*.center{*/
        /*    width: 70px;*/
        /*    left: 30px;*/
        /*}*/

        /*.width{*/
        /*    width: 50px;*/
        /*}*/
    </style>
</head>
<body>
<div >
    <table >
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <a href="/spring/save/${student.id}" >修改</a>
                    <a href="/spring/deleteById/${student.id}" >删除</a>

                </td>
            </tr>
        </c:forEach>
    </table><br/>
    <a href="/save.jsp" >添加</a>

</div>
</body>
</html>
