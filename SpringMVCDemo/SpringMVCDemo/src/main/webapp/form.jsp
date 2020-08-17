<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/6/27
  Time: 2:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>

    <style >
        .center{
            margin: auto;
            width: 70%;
            /*background: aquamarine;*/
        }
    </style>
    <script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>

<%--    <div class="center" >--%>
<%--        <form:form action="/form/get" method="post" modelAttribute="user">--%>
<%--            id:<form:input path="id" />--%>
<%--            name:<form:input path="name" />--%>
<%--            address:<form:input path="address.value" />--%>
<%--            &lt;%&ndash;    password:<form:password path="address.value" />&ndash;%&gt;--%>
<%--            <input type="submit" value="提交">--%>
<%--            &lt;%&ndash;    <form:&ndash;%&gt;--%>
<%--        </form:form>--%>
<%--    </div>--%>

    <hr/>

    <div class="center">
        <form:form class="form-horizontal" action="/form/get" method="post" modelAttribute="person">
            id:<form:input path="id" />
            name:<form:input path="name" />
            address:<form:input path="address.value" /><br/>

            sex:<form:radiobutton path="sex" value="男" />男
            <form:radiobutton path="sex" value="女" />女

            <br/>
            hobby:<form:checkboxes path="selecthobby" items="${person.hobby}" />

            <br/>
            class:<form:radiobuttons path="classes" items="${person.classesList}" />


            city:
            <form:select path="city" items="${person.citys}"/>



            remember: <form:checkbox path="remember" value="remember" />

            <br/>

            <form:select path="city">
                <form:options items="${person.citys}" />
            </form:select>

            所在城市：<form:select path="city">
                <form:option value="1">杭州</form:option>
                <form:option value="2">成都</form:option>
                <form:option value="3">西安</form:option>
            </form:select><br/>

            信息：<form:textarea path="introduce"/><br/>



            <hr/>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>&nbsp;
                    <button type="button" class="btn btn-default">取消</button>
                </div>
            </div>
        </form:form>




    </div>


<%--    <form:form class="form-horizontal" method="post" action="/form/get" modelAttribute="person">--%>
<%--        <div class="form-group">--%>
<%--            <label for="inputId" class="col-sm-2 control-label">id</label>--%>
<%--            <div class="col-sm-5">--%>
<%--                <form:input id="inputId" class="form-control" path="id" />--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label for="name" class="col-sm-2 control-label">name</label>--%>
<%--            <div class="col-sm-5">--%>
<%--                <form:input path="name" class="form-control" id="name" />--%>
<%--            </div>--%>
<%--        </div>--%>


<%--        <div class="form-group">--%>
<%--            <label for="sex" class="col-sm-2 control-label">sex</label>--%>
<%--            <div class="col-sm-5">--%>
<%--                <form:input path="sex" class="form-control" id="sex" />--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        --%>
<%--        <div class="form-group">--%>
<%--            <div class="col-sm-offset-2 col-sm-10">--%>
<%--                <div class="checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="checkbox"> Remember me--%>
<%--                    </label>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <div class="col-sm-offset-2 col-sm-10">--%>
<%--                <button type="submit" class="btn btn-default">Sign in</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form:form>--%>

</body>
</html>
