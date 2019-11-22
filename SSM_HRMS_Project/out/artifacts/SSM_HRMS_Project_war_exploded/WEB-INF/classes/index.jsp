<%--
  Created by IntelliJ IDEA.
  User: 提拉米苏
  Date: 2019/11/19
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>员工页面</title>
<%--        获取服务器路径--%>
      <% pageContext.setAttribute("PASH",request.getContextPath());%>

      <script type="text/javascript" src="${PASH}/static/js/jquery-3.4.1.min.js"></script>
      <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

      <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

      <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </head>
  <body>
    <div class="container">
<%--      标题--%>
      <div class="row">
        <div class="col-md-12">
          <h1>SSM-CRUD</h1>
        </div>
      </div>
<%--      按钮--%>
      <div class="row">
        <div class="col-md-4 col-md-offset-8">
          <!-- Indicates caution should be taken with this action -->
          <button type="button" class="btn btn-warning" id="emp_add_modal_btn">新增</button>

          <!-- Indicates a dangerous or potentially negative action -->
          <button type="button" class="btn btn-danger" id="emp_delete_modal_btn">删除</button>
        </div>
      </div>
<%--  显示表格数据--%>
      <div class="row"></div>
          <div class="col-md-12">
<%--              添加id方便后面插入数据--%>
            <table class="table table-hover" id="emp_table">
                <thead>
                  <tr>
                      <th><input type="checkbox" id="check_all" /> </th>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
          </div>
<%--        分页--%>
      <div class="row">
<%--          分页文字信息--%>
          <div class="col-md-6" id="page_text_Info"></div>
<%--          分页条--%>
          <div class="col-md-6" id="page_nav_area"></div>
      </div>
    </div>
  </body>
<%--    减少代码臃肿 将模态框从别的jsp引入--%>
    <jsp:include page="static/jsp/emp_modal_add.jsp"></jsp:include>
  <jsp:include page="static/jsp/emp_modal_update.jsp"></jsp:include>
    <script>
        // 总记录数 当前页设为全局变量 后边跳转需要
        var totalRecord,currentPage;

        //==========================获取员工分页数据==============================
        // 加载完成直接发送ajax请求
        $(function () {
            to_page(1);
        });
        // ajax请求跳转页面
        function to_page(pageNumber) {
            $.ajax({
                url:"/SSM_HRMS_Project_war_exploded/EmployeeController/getEmps",
                type:"GET",
                data:"pageNumber="+pageNumber,
                success:(function (result) {
                    if (result.code==100){
                        // 解析员工数据
                        build_emps_table(result);
                        // 解析分页信息
                        build_page_Info(result);
                        // 解析分页条信息
                        build_page_nav(result);
                    }else{
                        alert(result.extendInfo.emp_error_getEmps);
                    }

                })
            });
        }

        // 解析员工数据
        function build_emps_table(result) {
            //清空  防止重复插入相同数据
            $("#emp_table tbody").empty();
            // 获取page的查询结果list
            var emps=result.extendInfo.page.list;
            //item是遍历元素 index是索引
            $.each(emps,function (index, item) {
                //将数据放到 TD标签中
                var checkbox=$("<td><input type='checkbox' class='check_item'/></td>");
                var empid=$("<td></td>").append(item.empId);
                var empName=$("<td></td>").append(item.empName);
                var email=$("<td></td>").append(item.email);
                var gender=$("<td></td>").append((item.gender)=='M'?"男":"女");
                var departmentName=$("<td></td>").append(item.department.deptName);
                // 先在button中添加class   再将<span>标签放到button中 在<span>标签中添加class 在将编辑加入标签中
                var edit_btn=$("<button></button>").addClass("btn btn-primary btn-sm  edit_btn").append("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑");
                // 给每个员工的编辑按钮添加一个员工id 方便编辑时查询信息
                edit_btn.attr("edit-id",item.empId);
                var delete_btn=$("<button></button>").addClass("btn btn-success btn-sm  delete_btn").append("<span></span>").addClass("glyphicon glyphicon-trash").append("删除");
                //给每个员工的删除按钮添加一个员工id 方便删除时传值
                delete_btn.attr("delete-id",item.empId);
                // 把按钮放到一个单元格中
                var btnTD=$("<td></td>").append(edit_btn).append("  ").append(delete_btn);
                //append()返回值为自身元素
                // 将所有TD列放到行标签TR中 最后添加到TBODY中
                $("<tr></tr>").append(checkbox)
                    .append(empid)
                    .append(empName)
                    .append(gender)
                    .append(email)
                    .append(departmentName)
                    .append(btnTD)
                    .appendTo("#emp_table tbody");
            })
        }

        // 解析分页信息
        function build_page_Info(result) {
            $("#page_text_Info").empty();
            // 获取pageInfo
            var pageInfo=result.extendInfo.page;
            // 当前页
            currentPage=pageInfo.pageNum;
            // 总页数
            var totalPages=pageInfo.pages;
            //总记录数
            totalRecord = pageInfo.total;
            // 插入到分页信息div里
            $("#page_text_Info").append("第"+currentPage+"页，共"+totalPages+"页，总共有"+totalRecord+"条记录");
        }

        // 解析分页条信息
        function build_page_nav(result) {
            //删除重复的分页条
            $("#page_nav_area").empty();
            //ul
            var ul=$("<ul></ul>").addClass("pagination");
            //首页
            var firstPage=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            //上一页&laquo;
            var prePage=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
            //如果没有前一页则给首页和上一页按钮添加一个标识
            if(!result.extendInfo.page.hasPreviousPage){
                firstPage.addClass("disabled");
                prePage.addClass("disabled");
            }else {
                //如果有上一页 为页面增加点击事件 首页
                firstPage.click(function () {
                    to_page(1);
                })
                //上一页
                prePage.click(function () {
                    to_page(result.extendInfo.page.pageNum-1);
                })
            }

            //下一页
            var nextPage=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
            //尾页
            var lastPage=$("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
            if(!result.extendInfo.page.hasNextPage){
                nextPage.addClass("disabled");
                lastPage.addClass("disabled");
            }else {
                nextPage.click(function () {
                    to_page(result.extendInfo.page.pageNum+1);
                })
                lastPage.click(function () {
                    to_page(result.extendInfo.page.pages);
                })
            }

            //先将前两个按钮添加到ul
            ul.append(firstPage).append(prePage)
            //1,2,3,4,5 遍历生成页码的同时 将页码插入分页条
            $.each(result.extendInfo.page.navigatepageNums,function (index,item) {
                var pageNum=$("<li></li>").append($("<a></a>").append(item).attr("href","#"));
                // 给当前页码加上深色
                if(result.extendInfo.page.pageNum === item){
                    pageNum.addClass("active");
                }
                pageNum.click(function () {
                    to_page(item);
                })
                ul.append(pageNum);
            });
            // 最后插入下一页跟尾页
            ul.append(nextPage).append(lastPage)
            //按bootstrap要求创建nav 并把ul添加到nav
            var nav=$("<nav></nav>").append(ul).attr("aria-label","Page navigation");
            //从内到外 最后把nav插入到分页条div中
            $("#page_nav_area").append(nav);
            // 或nav.appendTo("#page_nav_area");
        }


        // ===============================单个删除员工=============================
        //跟编辑按钮同理 利用on绑定点击事件
        $(document).on("click",".delete_btn",function () {
          var empName=$(this).parents("tr").find("td:eq(2)").text();
            //用confirm返回值做判断
          if(confirm("是否要删除【"+empName+"】")){
              $.ajax({
                  url:"/SSM_HRMS_Project_war_exploded/EmployeeController/deleteEmp?empIds="+$(this).attr("delete-id"),
                  type:"DELETE",
                  success:function (result) {
                      if(result.code==100){
                          alert(result.extendInfo.emp_success_deleteEmp);
                          to_page(currentPage);
                      }else{
                          alert(result.extendInfo.emp_fail_deleteEmp);
                      }
                  }
              })
          }
        })


        // ================================完成全选/全不选============================
        $("#check_all").click(function () {
            //attr获取checked是undefined
            //利用prop获取dom原生属性的值，attr获取自定义属性的值
            $(".check_item").prop("checked",$(this).prop("checked"));
        })

        // 修改全选后check_all的checked值 (true||false)
        $(document).on("click",".check_item",function () {
            //:checked过滤器 匹配所有被选中的check_item元素
            var result= $(".check_item:checked").length==$(".check_item").length
            //如果相等result=true check_all修改为选中状态 否则反之
            $("#check_all").prop("checked",result);
        })



        // ================================全删除=================================
        $("#emp_delete_modal_btn").click(function () {
            // 如果当前有选中的checkbox才会发起ajax请求
            if ($(".check_item:checked").length>0){
                var empNames="";
                var empIds="";
                //将选中的员工id遍历
                $.each($(".check_item:checked"),function () {
                    empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
                    //将要删除的id组装成字符串 到后端在进行拆分
                    empIds += $(this).parents("tr").find("td:eq(1)").text()+"-";
                });
                //substring去掉最后一个逗号 短杠
                empNames = empNames.substring(0,empNames.length-1);
                empIds = empIds.substring(0,empIds.length-1);
                if(confirm("确定要删除【"+empNames+"】?")){
                    $.ajax({
                        url:"/SSM_HRMS_Project_war_exploded/EmployeeController/deleteEmp?empIds="+empIds,
                        type:"DELETE",
                        success:function (result) {
                            if (result.code==100){
                                alert(result.extendInfo.emp_success_deleteEmp);
                                to_page(currentPage);
                            }else {
                                alert(result.extendInfo.emp_fail_deleteEmp);
                            }
                        }
                    })
                }
            }
        })

    </script>



</html>
