$(document).on("click",".emp_delete_btn", function () {

    // alert($(this).parents("tr").find("td:eq(1)").text());
    var empName = $(this).parents("tr").find("td:eq(2)").text();
    if(confirm("确认删除【"+ empName + "】吗？")) {

        $.ajax({
            url: App_Path + "/emp/" + $(this).attr("emp_id_delete"),
            type: "DELETE",
            success: function (result) {
                if (result.code === 200) {
                    alert("删除成功！");
                    to_page_nu($("#page_info_result").attr("page"));
                } else {
                    alert("删除失败！")
                }
            }
        });
    }else{
        return false;
    }
});


//checkAll
$("#check_all").click(function () {
    // attr 获取 checked is undefined
    // prop 获取原生属性
    // alert($(this).prop("checked"));
    $(".check_item").prop("checked",$(this).prop("checked"));
});

$(document).on("click",".check_item",function () {
    // 判断选中的元素是否为  page number
    // alert($(".check_item:checked").length);
    var tag = $(".check_item:checked").length === $(".check_item").length;
    $("#check_all").prop("checked",tag);
});

$(document).on("click","#emp_delete_some_btn",function () {
    var names = "";
    var ids = ""
    $.each($(".check_item:checked"), function () {
        var name = $(this).parents("tr").find("td:eq(2)").text();
        names += name + ",";
        ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
    });
    // 去除多余的，
    names = names.substring(0, names.length-1);
    ids = ids.substring(0,ids.length -1);
    if(confirm("确定要删除所选【"+ names +"】信息吗？")){
        // alert(ids);
        $.ajax({
            url: App_Path + "/emp/" +ids,
            type: "DELETE",
            success: function (result) {
                if (result.code === 200) {
                    alert("删除成功！");
                    to_page_nu($("#page_info_result").attr("page"));
                    if($("#check_all").prop("checked")){
                        $("#check_all").prop("checked",false);
                    }
                } else {
                    alert("删除失败！")
                }
            }
        });

    }
});