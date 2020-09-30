<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2020/8/15
  Time: 4:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        pageContext.setAttribute("App_Path",request.getContextPath());
        String AppPath = request.getContextPath();
    %>
    <script src="${App_Path}/static/js/jquery-3.5.1.min.js" ></script>

    <title>Ajax</title>
</head>
<body>
<form action="${App_Path}/json" method="post">
    <%=AppPath%>
    <input type="text" name="String" >
    <input type="submit" name="点击" value="button">
</form>


<a id="a1" href="" >POST</a>


<script type="text/javascript">
    // json = {
    //     "String":1,
    //     "name":"KawYang"
    // }
    // alert(json.name);
    // var s = JSON.stringify(json);

    $("#a1").click (function(){
        $.ajax({
            url:"${App_Path}/json",
            method:"POST",
            data:{ "String":"String","name":"KawYang"},
            success:function (result) {
                alert("成功！");
                alert(result.toString());
                console.log(1);
            }
        });
    });

    <%--$("#a1").click(function () {--%>
    <%--    $.ajax({--%>
    <%--        url:"${App_Path}/json",--%>
    <%--        method:"POST",--%>
    <%--        data:{ "String":"String","name":"KawYang"},--%>
    <%--        success:function (result) {--%>
    <%--            alert("成功！");--%>
    <%--            alert(result.toString());--%>
    <%--            console.log(2);--%>
    <%--        }--%>
    <%--    });--%>
    <%--});--%>
</script>
</body>

</html>
