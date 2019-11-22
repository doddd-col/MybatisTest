<%--
  Created by IntelliJ IDEA.
  User: 提拉米苏
  Date: 2019/11/21
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div class="modal fade" id="emp_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                            <label class="control-label" for="empName_add_input">Name</label>
                            <%--当label标签里面加上for=“某个input id的值”时 点击label也会触发该input   placeholder是框里的提示信息--%>
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="Jerry">
                            <span class="help-block"></span>
                            <span class="help-block" id="name_tip"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="email_add_input">Email</label>
                            <input type="email" name="email" class="form-control" id="email_add_input" placeholder="Jerry@qq.com">
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
                            <label for="dept_add_select">所属部门</label>
                            <select id="dept_add_select" class="form-control" name="deptId">
                                <%--<option>人事部</option>--%>
                            </select>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="emp_save_btn">Save changes</button>
                </div>
            </div><%-- //////modal-content--%>
        </div><%-- //////modal-dialog--%>
    </div><%-- //////emp_add_modal--%>
</body>

<script>

    //============================新增员工模态框===============================
    //增加模态框
    $("#emp_add_modal_btn").click(function () {
        //传模态框的表单 否则找不到该方法
        reset_form_style("#emp_add_modal form");
        //查询部门信息 放到select中 回显下拉列表
        getDeptName("#dept_add_select");
        $('#emp_add_modal').modal({
            backdrop:'static',
        })
    })

    //清空表单并重置表单样式
    function reset_form_style(ele){
        //清空模态框内容 因为jQuery没有reset方法所以调用dom对象来使用
        $(ele)[0].reset();
        //清空表单下所有元素的"has-success has-error has-feedback"
        $(ele).find("*").removeClass("has-success has-error has-feedback");
        //清空样式和提示语句
        $(ele).find(".help-block").removeClass("glyphicon glyphicon-remove glyphicon-ok form-control-feedback").text("");
    }

    //获取部门列表
    function getDeptName(ele) {
        $(ele).empty();//利用empty 清空重复的请求数据
        $.ajax({
            url:"/SSM_HRMS_Project_war_exploded/DepartmentController/getDepts",
            type:"GET",
            success:function (result) {
                if(result.code==100){
                    $.each(result.extendInfo.depts,function () {
                        //不用遍历元素item 也可以用this代替当前遍历元素
                        var option_dept=$("<option></option>").append(this.deptName).attr("value",this.deptId);
                        option_dept.appendTo(ele);
                    })
                }else{
                    alert(result.extendInfo.dept_error_getDept);
                }
            }
        })
    }



    //========= 校验表单数据 当鼠标从输入框移开的时候，判断输入框内容是否正确 ============
    //利用正则表达式进行校验 从jQuery文档获取
    //------------------新增姓名校验---------------------
    $("#empName_add_input").change(function () {
        var empName=$("#empName_add_input").val();
        var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(empName)){
            //输入框状态验证
            check_validate_return("#empName_add_input","fail","用户名可以是2-5位中文或者6-16位英文数字混合");
        }else {
            // 如果用户名可用 显示success 如果重复则fail
            checkName();
        }
    })

    //检验名字是否重复
    function checkName(){
        $.ajax({
            url:"/SSM_HRMS_Project_war_exploded/EmployeeController/checkName",
            type:"GET",
            data:"name="+$("#empName_add_input").val(),
            success:function (result) {
                if (result.code==100){
                    check_validate_return("#empName_add_input","success","用户名可用");
                }else {
                    check_validate_return("#empName_add_input","fail","用户名重复");
                }
            }
        })
    }

    //------------------新增邮箱校验---------------------
    $("#email_add_input").change(function () {
        var eamil=$("#email_add_input").val();
        var regEmail=/^([a-zA-Z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(eamil)){
            check_validate_return("#email_add_input","fail","邮箱格式不正确");
        }else{
            check_validate_return("#email_add_input","success","邮箱格式正确");
        }
    })

    //修改输入框的验证状态
    function check_validate_return(ele,status,msg){
        //因为第一次添加了class之后不能覆盖 所有需要删除上一次的状态 否则第二验证无法修改验证状态
        $(ele).parent().removeClass("has-success has-error has-feedback");
        $(ele).next().removeClass("glyphicon glyphicon-remove glyphicon-ok form-control-feedback");
        if(status=="success"){
            //在父级元素添加 固定条件即可提示
            $(ele).parent().addClass("has-success has-feedback");
            //next()指的是容纳√×图标的span标签  修改里面的内容
            $(ele).next().addClass("glyphicon glyphicon-ok form-control-feedback");
            //输入框下面的提示语句
            $(ele).next().next().text(msg);
        }else if(status=="fail"){
            $(ele).parent().addClass("has-error has-feedback");
            $(ele).next().addClass("glyphicon glyphicon-remove form-control-feedback");
            $(ele).next().next().text(msg);
        }
    }




    //==============================保存信息======================================
    //保存前对表单信息进行后端校验
    $("#emp_save_btn").click(function () {
        //在模态框中对表单数据进行校验
        if($("#name_tip").text()!="用户名可用" || $("#email_tip").text()!= "邮箱格式正确"){
            return false;
        }
        $.ajax({
            url:"/SSM_HRMS_Project_war_exploded/EmployeeController/saveEmp",
            type:"POST",
            data:$("#emp_Info_form").serialize(),//序列化表单字符串用于ajax请求
            success:function (result) {
                if (result.code==100){
                    //1.员工保存成功
                    alert(result.extendInfo.emp_success_saveEmp);
                    //2.增加成功后关闭模态框
                    $("#emp_add_modal").modal('hide');
                    // 3.前往最后一页 查看数据 因为开启了reasonable合理管理页面 所有当跳转的页码大于最后一页自动跳到最后一页 所以利用总记录数totalRecord进行页码跳转 （如果利用最后一页有可能增加的刚好多出一页，，，不可能页码比记录多）
                    to_page(totalRecord);
                    // 清空表单
                }else {
                    var fail=result.extendInfo.emp_fail_saveEmp;
                    // 如果map里面没有定义email name则不修改输入框状态 存在map里就是错误信息
                    if(undefined !=fail.email){
                        check_validate_return("#email_add_input","fail",fail.eamil);
                    }else if (undefined !=fail.empName){
                        check_validate_return("#empName_add_input","fail",fail.empName);
                    }else if(undefined !=fail.repeat){
                        check_validate_return("#empName_add_input","fail",fail.repeat);
                    }
                }
            }
        })
    })





</script>
</html>
