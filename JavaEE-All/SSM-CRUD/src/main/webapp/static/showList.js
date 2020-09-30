var totalRecord;

//1、页面加载完成后发送ajax请求，获取表格数据
to_page_nu(1);

function to_page_nu(number) {
    $(function () {
        $.ajax({
            url: App_Path + "/emps-msg",
            data:"page="+number,
            type:"GET",
            success:function (result) {
                // console.log(result);
                //1、解析表格数据
                build_emps_table(result);
                //2、解析显示分页信息
                build_page_info(result);
                build_page_nel(result);
                totalRecord = result.extend.pageInfo.total;
            }
        })

    });
}

//创建表格
function build_emps_table(result) {

    //清空数据
    $("#emps_table tbody").empty();
    var emps = result.extend.pageInfo.list;
    $.each(emps,function (index, item) {
        //alert(index+item.empName);
        var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>");
        var empIdTd = $("<td></td>").append(item.empId);
        var empNameTd = $("<td></td>").append(item.empName);

        var genderTd = $("<td></td>").append(item.gender=="M"?"男":"女");
        var emailTd = $("<td></td>").append(item.email);
        var deptNameTd = $("<td></td>").append(item.department.deptName);


        var edit_button = $("<button></button>").addClass("btn btn-primary btn-sm emp_update_btn")
            .attr("emp_id_update",item.empId)
            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");

        var delete_button = $("<button></button>").addClass("btn btn-danger btn-sm emp_delete_btn")
            .attr("emp_id_delete",item.empId).attr("id","delete_some_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");

        var button_td = $("<td></td>").append(edit_button).append(" ").append(delete_button);
        $("<tr></tr>").append(checkBoxTd)
            .append(empIdTd)
            .append(empNameTd).append(genderTd)
            .append(emailTd).append(deptNameTd)
            .append(button_td)
            .appendTo("#emps_table tbody");
    });
};


// 分页信息
function build_page_info(result) {
    //清空数据
    $("#page_info_result").empty();

    $("#page_info_result").attr("page",result.extend.pageInfo.pageNum)
        .append("当前第"+result.extend.pageInfo.pageNum +
        "页,总共"+result.extend.pageInfo.pages+"页，" +
        "总共"+result.extend.pageInfo.total+ "条数据");

    // $("#page_info").append("当前第<span class=\"badge\">"+result.extend.pageInfo.pageNum+
    //     "</span>页,总共<span class=\"badge\"> "+result.extend.pageInfo.pages+"</span>页，" +
    //     "总共<span class=\"badge\"> "+result.extend.pageInfo.total+ "</span> 条数据");
}

//分页条显示
function build_page_nel(result) {
    //
    $("#page_nel").empty();
    // 分页条显示  start
    var ul = $("<ul></ul>").addClass("pagination")
    var first_page_li = $("<li></li>").append($("<a></a>").append("首页"));
    var forword_page_li =  $("<li></li>").append($("<a></a>").append("&laquo;"));
    var next_page_li =  $("<li></li>").append($("<a></a>").append("&raquo;"));
    var last_page_li =  $("<li></li>").append($("<a></a>").append("末页"));

    first_page_li.click(function () {
        to_page_nu(1);
    });
    forword_page_li.click(function () {
        to_page_nu(result.extend.pageInfo.pageNum-1);
    });
    next_page_li.click(function () {
        to_page_nu(result.extend.pageInfo.pageNum+1);
    });
    last_page_li.click(function () {
        to_page_nu(result.extend.pageInfo.pages);
    });
    ul.append(first_page_li);
    if( !result.extend.pageInfo.isFirstPage){
        ul.append(forword_page_li);
    }
    if(result.extend.pageInfo.isFirstPage){
        first_page_li.addClass("disabled");
        // forword_page_li.addClass("disabled");
    }
    $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
        var num_li =  $("<li></li>").append($("<a></a>").append(item)   );
        if(result.extend.pageInfo.pageNum == item){
            num_li.addClass("active");
        }
        num_li.click(function () {
            to_page_nu(item);
        });
        ul.append(num_li);
    });

    if(!result.extend.pageInfo.isLastPage){
        ul.append(next_page_li);
    }
    if(result.extend.pageInfo.isLastPage){
        last_page_li.addClass("disabled");
        // next_page_li.addClass("disabled");
    }
    ul.append(last_page_li);
    var navEml = $("<nav></nav>").addClass("Page navigation").append(ul);

    $("#page_nel").append(navEml);
    // end
}

// 查询 部门信息
show_dept_name("#emp_add_modle select");

function show_dept_name(ele) {
    alert(App_Path);
    $.ajax({
        url:App_Path + "/depts",
        type:"GET",
        success:function (result) {
            console.log(result);
            $.each(result.extend.depts,function (index,item) {
                var option = $("<option></option>").append(item.deptName)
                    .attr("value",item.deptId);
                console.log(option.toString())
                option.appendTo(ele);
            });
        }
    });
};

