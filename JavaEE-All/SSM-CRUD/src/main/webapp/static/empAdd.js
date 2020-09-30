// 弹出模态框
$("#emp_add_model_btn").click(function () {

    //重制表单
    reset_form($("#emp_add_modle form"));

    //添加按钮点击事件
    $("#emp_add_modle").modal({
        backdrop:"static"
    });
});

function reset_form(ele) {
    ele[0].reset();
    ele.find("*").removeClass("has-error has-success");
    ele.find("span").text("");
}


// 校验表单数据
function validate_add_form(){
    // 1. 获取校验的数据，使用正则表达式进行校验
    var empName = $("#empName_input").val();
    var regName = /(^[a-z0-9A-Z_-]{6,15}$)|(^[\u4e00-\u9fa5]{2,5})/;
    var empNameIsOk = regName.test(empName);
    var empNameInput = $("#empName_input");
    //清空修改的数据信息

    if(!$("#empName_input").parent().hasClass("has-error")){
        /**empName 校验*/
        if(!empNameIsOk){
            // 参考内容  https://v3.bootcss.com/css/#forms-control-validation  表单-> 校验状态
            //提示信息在页面显示
            // empNameInput.parent().addClass("has-error");
            // empNameInput.next("span").append("用户名英文6-15位，中文要求3-5位").addClass("has-error");

            show_validate_msg(empNameInput,"error","用户名英文6-15位，中文要求3-5位");
        }else{
            // empNameInput.parent().addClass("has-success");
            // empNameInput.next("span").text("");
            show_validate_msg(empNameInput,"success","");
        }
    }


    /**
     * email 校验
     * @type {jQuery|string|undefined}
     */
    var email = $("#email_input").val();
    var regEmail = 	/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/
    var emailIsOk =regEmail.test(email);
    var emailInput = $("#email_input");
    if(!emailIsOk){
        // alert("邮箱格式错误！");
        // emailInput.parent().addClass("has-error");
        // emailInput.next("span").append("邮箱格式错误！").addClass("has-error");
        show_validate_msg(emailInput,"error","邮箱格式错误！")
    }else {
        show_validate_msg(emailInput,"success","");
    }

    /**
     * select Element 校验
     * @type {*|jQuery.fn.init|jQuery|HTMLElement}
     */
    var selectElement = $("#deptName_select");
    var deptSelectIsOk = selectElement.val() != -1;
    if(!deptSelectIsOk){
        // selectElement.parent().addClass("has-error");
        // selectElement.next("span").addClass("has-error").append("请选择部门信息！");
        show_validate_msg(selectElement,"error","请选择部门信息！");
    }else{
        show_validate_msg(selectElement,"success","");
    }
    if(empNameIsOk && emailIsOk && deptSelectIsOk){
        return true;
    }

}

function show_validate_msg(ele,status,msg){
    ele.parent().removeClass("has-success has-error");
    if(status === "success"){
        ele.parent().addClass("has-success");
        ele.next("span").text(msg);
    }else if(status === "error"){
        ele.parent().addClass("has-error");
        ele.next("span").text(msg);
    }
}

//
$("#empName_input").change(function () {
    $.ajax({
        url:App_Path + "/checkuser",
        data:"empName=" + $("#empName_input").val(),
        type:"POST",
        success:function (result) {
            if(result.code === 200){
                //success
                show_validate_msg($("#empName_input"),"success","用户名可用");
                $("#emp_save_btn").attr("ajax-va","success");
            }else{
                //fail
                show_validate_msg($("#empName_input"),"error",result.extend.va_msg);
                $("#emp_save_btn").attr("ajax-va","error");
            }
        }
    });
});



// 点击保存事件
$("#emp_save_btn").click(function () {
    var data_add_emp = $("#emp_add_modle form").serialize();
    // alert(data_add_emp);
    //0 数据校验
    // if(!validate_add_form()){
    //     return false;
    // }

    //如果 userName 不可用
    if($("#emp_save_btn").attr("ajax-va") === "error") {
        return false;
    }
    //1。 发送请求
    //2. 保存数据
    $.ajax({
        url:App_Path + "/emp",
        type:"POST",
        //数据模态框中的数据
        data:data_add_emp,
        success:function (result) {
            if(result.code === 200){
                alert("数据添加成功！");
                //关闭模态框
                $("#emp_add_modle").modal('hide');
                //来到最后一页
                to_page_nu(totalRecord);
            }else {
                if(undefined !== result.extend.errorFields.email){
                    show_validate_msg($("#email_input"),"error",result.extend.errorFields.email);
                }else {
                    show_validate_msg($("#email_input"),"success","");
                }
                if(undefined !== result.extend.errorFields.dId){
                    show_validate_msg($("#deptName_select"),"error",result.extend.errorFields.dId);
                }else {
                    show_validate_msg($("#deptName_select"),"success","");
                }

                console.log(result);
            }

        }
    });

});

