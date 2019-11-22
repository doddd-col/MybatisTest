<%--
  Created by IntelliJ IDEA.
  User: 提拉米苏
  Date: 2019/11/21
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Modal -->
    <div class="modal fade" id="emp_update_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <%--                模态框头部--%>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">员工资料</h4>
                </div>
                <div class="modal-body">
                    <%--                    表单--%>
                    <form id="emp_Info_form">
                        <%--                        输入框 输入框的提示标签--%>
                        <div class="form-group">
                            <label class="control-label">Name</label>
<%--                            在p标签的class中加上form-control-static就会变成固定文本 无法选中--%>
                            <p class="form-control-static" id="empName_update_static">email@example.com</p>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="email_update_input">Email</label>
                            <input type="email" name="email" class="form-control" id="email_update_input" placeholder="Jerry@qq.com">
                            <span class="help-block"></span>
                            <span class="help-block" id="email_tip"></span>
                        </div>
                        <%--                        单选radio按钮--%>
                        <div class="form-group">
                            <label >Gender&nbsp;&nbsp;&nbsp;</label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="male" value="M" checked="checked">男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="female" value="F">女
                            </label>
                        </div>
                        <%--                            部门下拉列表--%>
                        <div class="form-group">
                            <label for="dept_update_select">所属部门</label>
                            <select id="dept_update_select" class="form-control" name="deptId">
                                <%--<option>人事部</option>--%>
                            </select>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="emp_save_update_btn">Save changes</button>
                </div>
           </div><%-- //////modal-content--%>
         </div><%-- //////modal-dialog--%>
    </div><%-- //////emp_add_modal--%>
</body>

<script>
    //===============================表单删除按钮===============================
    // 1.因为按钮是跟随员工数据一起创建的 所有按钮生成在绑定之后 所以绑定不上
    // 1）可以在按钮生成时绑定 2）绑定点击.live（）
    //jQuery新版没有live 所以使用on进行代替
    $(document).on("click",".edit_btn",function () {
        //弹出模态框
        $("#emp_update_modal").modal({
            backdrop: 'static',
        })

        // $.when(getDeptName("#dept_update_select")).done(getEmp($(this).attr("edit-id")))
        //查询部门信息
        getDeptName("#dept_update_select");
        //查询当前员工信息 获取当前被点击的编辑按钮id
        getEmp($(this).attr("edit-id"));
        // 把员工id传给模态框的更新按钮
        $("#emp_save_update_btn").attr("edit-id",$(this).attr("edit-id"));
    })

    //获取员工信息
    function getEmp(id) {
        $.ajax({
            url:"/SSM_HRMS_Project_war_exploded/EmployeeController/getEmp",
            type:"GET",
            data:"id="+id,
            success:function (result) {
                if (result.code==100){
                    var empInfo=result.extendInfo.emp;
                    $("#empName_update_static").text(empInfo.empName);
                    $("#email_update_input").val(empInfo.email);
                    //选中emp_update_modal 里面的input属性里面 name=gender的元素  []里面可以放入特殊条件 用来筛选元素
                    $("#emp_update_modal input[name=gender]").val([empInfo.gender]);
                    $("#emp_update_modal select").val([empInfo.deptId]);
                }
            }

        })
    }

    // 保存已修改的员工信息
    $("#emp_save_update_btn").click(function () {
        // 信息校验
        //------------------修改邮箱校验---------------------
        $("#email_update_input").change(function () {
            var eamil=$("#email_update_input").val();
            var regEmail=/^([a-zA-Z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (!regEmail.test(eamil)){
                check_validate_return("#email_update_input","fail","邮箱格式不正确");
                return false;
            }else{
                check_validate_return("#email_update_input","success","邮箱格式正确");
            }
        })

        // 发起ajax请求进行保存
        $.ajax({
            url:"/SSM_HRMS_Project_war_exploded/EmployeeController/updateEmp/"+$(this).attr("edit-id"),
            type:"PUT",
            data:$("#emp_update_modal form").serialize(),
            success:function (result) {
                if (result.code==100){
                    //1.修改成功后关闭模态框
                    $("#emp_update_modal").modal('hide');
                    //2.弹出更新成功提示
                    alert(result.extendInfo.emp_success_updateEmp);
                    //3.重新跳转到当前页面刷新数据
                    to_page(currentPage);
                }else {
                    alert(result.extendInfo.emp_fail_updateEmp);
                }
            }
        })
    })
</script>

</html>
