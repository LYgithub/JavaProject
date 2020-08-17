//绑定事件
//1、常见button对象时绑定
//2、使用 on 方法，绑定文本中所有的 emp——update——btn属性控件 的 click 属性
$(document).on("click",".emp_update_btn",function () {

    reset_form($("#emp_update_modle form"));

    add_date_for_update_model($(this).attr("emp_id_update"));
    // $("#emp_update_modle form")[0].reset();
    $("#emp_update_modle").modal({
        backdrop:"static"
    });
});


//加载 部门信息
show_dept_name($("#emp_update_modle select"));

// 给 模态框 添加数据
function add_date_for_update_model(id) {
    $.ajax({
        url:App_Path + "/empbyid/"+id,
        type:"GET",
        success:function (result) {
            console.log(result);
            $("#emp_update_btn").attr("emp_save_id",id);
            // important
            $("#empName_update_static").text(result.extend.emp.empName);
            $("#email_update_input").val(result.extend.emp.email);
            //参考内容： https://jquery.cuishifeng.cn/val.html  radio 需要传递数组集合参数
            // $("#emp_update_modle input[type=radio]").val([result.extend.emp.gender]);
            $("#emp_update_modle input[name=gender]").val([result.extend.emp.gender]);
            $("#emp_update_modle select[name=dId]").val(result.extend.emp.dId);

        }
    });
};


//update button
$("#emp_update_btn").click(function () {

    var email = $("#email_update_input").val();
    var regEmail = 	/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/
    var emailIsOk =regEmail.test(email);
    var emailInput = $("#email_update_input");
    emailInput.empty();
    if(!emailIsOk){
        // alert("邮箱格式错误！");
        // emailInput.parent().addClass("has-error");
        // emailInput.next("span").append("邮箱格式错误！").addClass("has-error");
        show_validate_msg(emailInput,"error","邮箱格式错误！");
        return false;
    }else {
        show_validate_msg(emailInput,"success","");
    }

    $.ajax({

        url:App_Path + "/emp-update/" + $(this).attr("emp_save_id"),
        type:"PUT",
        //数据模态框中的数据
        data: $("#emp_update_modle form").serialize(),
        success:function (result) {
            if(result.code === 200){
                //关闭模态框
                $("#emp_update_modle").modal('hide');
                alert("更新成功！");
                to_page_nu($("#page_info_result").attr("page"));
            }else {
                alert("更新失败！");
            }
        }
    });
});

