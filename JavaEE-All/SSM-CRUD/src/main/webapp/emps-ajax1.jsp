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
以 / 开始的相对路径，找资源，以服务器路径为基准
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

<%--  model update  start  --%>
<!-- Modal -->
<div class="modal fade" id="emp_update_modle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel_update">员工-修改</h4>
            </div>
            <div class="modal-body">
                <%-- 表单 --%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_input" class="col-sm-2 control-label">EmpName</label>
                        <%--<div class="col-sm-10">--%>
                        <%--    <input type="text" name="empName" class="form-control" id="empName_update_input" placeholder="EmpName">--%>
                        <%--    <span class="help-block"></span>--%>
                        <%--</div>--%>

                        <div class="col-sm-10">
                            <p class="form-control-static" name="empName" id="empName_update_static"></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_update_input" placeholder="email@163.com">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2" value="W"> 女
                            </label>
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%-- 提交部门ID即可  --%>
                            <select class="form-control" name="dId">
                            </select>
                        </div>

                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>

<%-- model update end   --%>


<%--  model  start  --%>
<!-- Modal -->
<div class="modal fade" id="emp_add_modle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工-添加</h4>
            </div>
            <div class="modal-body">
                <%-- 表单 --%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_input" class="col-sm-2 control-label">EmpName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_input" placeholder="EmpName">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_input" placeholder="email@163.com">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2" value="W"> 女
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%-- 提交部门ID即可  --%>
                            <select id="deptName_select" class="form-control" name="dId">
                                <option value="-1" > --- 请选择 ---</option>
                            </select><span class="help-block"></span>
                        </div>

                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<%-- model  end   --%>
<%

%>
<div class="container">
    <%--  标题行  --%>
    <div class="row" >
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%-- 按钮行 --%>
    <div class="row" >
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_model_btn" data-toggle="modal">新增</button>
            <button class="btn btn-danger" id="emp_delete_some_btn">删除</button>
        </div>
    </div>
    <%-- 表格行--%>
    <div class="row" >
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <%--显示分页--%>
    <div class="row" >
        <%--分页信息--%>
        <div class="col-md-6" id="page_info_result">
        </div>
        <%--    分页条--%>
        <div class="col-md-6" id="page_nel">
        </div>
    </div>
    <%--  显示页面列表信息  --%>
    <script src="${APP_PATH}/static/showList.js" ></script>
    <%--  模态框  --%>
    <script src="${APP_PATH}/static/empAdd.js" ></script>
    <%--  更新事件  --%>
    <script src="${APP_PATH}/static/updateEmp.js" ></script>

    <script src="${APP_PATH}/static/deletdEmp.js" ></script>
</div>



</body>
</html>
