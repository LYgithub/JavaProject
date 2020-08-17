<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/7/26
  Time: 9:17 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<%--
不以/ 开始的相对路径，找资源，以当前文件路径为基准
以/ 开始的相对路径，找资源，以服务器路径为基准
--%>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
    <script src="${APP_PATH}/static/js/jquery-3.5.1.min.js" ></script>

    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>
</head>
<body>
<%

%>
<div class="container"comment >
    <%--  标题行  --%>
    <div class="row" >
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%-- 按钮行 --%>
    <div class="row" >
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" >新增</button>
            <button class="btn btn-danger" >删除</button>
        </div>
    </div>
    <%-- 表格行--%>
    <div class="row" >
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <td>${emp.empId}</td>
                        <td>${emp.empName}</td>
                        <td>${emp.gender=="M"?"男":"女"}</td>
                        <td>${emp.email}</td>
                        <td>${emp.department.deptName}</td>
                        <td>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <%--显示分页--%>
    <div class="row" >
        <%--分页信息--%>
        <div class="col-md-6">
            当前第<span class="badge">${pageInfo.pageNum}</span>页,总共<span class="badge"> ${pageInfo.pages}</span>页，总共<span class="badge"> ${pageInfo.total}</span> 条数据
        </div>
        <%--    分页条--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <%-- 首页信息设置  --%>
                    <c:if test="${pageInfo.isFirstPage}" >
                        <li class="disabled"><a href="${APP_PATH}/emps?page=1" >首页</a></li>
                    </c:if>
                    <c:if test="${!pageInfo.isFirstPage}" >
                        <li><a href="${APP_PATH}/emps?page=1">首页</a></li>
                    </c:if>
                    <%--上一页--%>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a  href="${APP_PATH}/emps?page=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <%-- 中间页码显示 --%>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="number">
                        <c:if test="${pageInfo.pageNum == number}" >
                            <li class="active"><a href="/emps?page=${number}">${number}</a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != number}">
                            <li><a href="/emps?page=${number}">${number}</a></li>
                        </c:if>
                    </c:forEach>
                    <%--下一页--%>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${APP_PATH}/emps?page=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.isLastPage}">
                        <li class="disabled"> <a href="#">末页</a> </li>
                    </c:if>
                    <c:if test="${!pageInfo.isLastPage}">
                        <li> <a href="${APP_PATH}/emps?page=${pageInfo.pages}">末页</a> </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
