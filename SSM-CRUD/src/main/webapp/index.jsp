<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/7/25
  Time: 9:54 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
    <script src="static/js/jquery-3.5.1.min.js" ></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>
    </head>
<body>
    <button class="btn btn-success" >button</button>
    ${pageInfo.toString()}

    <h1>
        <c:forEach items="${list}" var="item">
            ${item.empName} -- ${item.empId} -- ${item.email} --
            <c:set var="gender" value="${item.gender}" />
            <c:if test="${  gender== 'M'}">
                男
            </c:if>
            <c:if test="${gender =='W'}">
                女
            </c:if>
            <br/>
        </c:forEach>
    </h1>
</body>
</html>
