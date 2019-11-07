
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="application/javascript" src="js/jquery-3.4.1.js"></script>
<script>
  $(document).ready(function (){
    $("#testJson").click(function (){
        //通过ajax请求SpringMVC
      $.post(
              "handler/testJson",//服务器地址
              //{name:"zs"}请求参数
              function (result) {//回调函数
                  for(var i=0;i<result.length;i++){
                    alert(result[i].id+"-"+result[i].name);
                }
              }
      )
    }

    )

  })

</script>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <input type="button" value="testJson" id="testJson">

  <a href="handler/welcome">welcome</a>
  <form action="handler/welcome" method="post" >
    <input type="submit" value="post" />
  </form>

  <form action="/SpringMvc_war_exploded/handler/testget" method="get" >
    <input type="submit" value="查" />
  </form>
  <form action="/SpringMvc_war_exploded/handler/testpost" method="post" >
    <input type="submit" value="增" />
  </form>
  <form action="/SpringMvc_war_exploded/handler/testdelete" method="post" >
    <input type="hidden" name="_method" value="DELETE" />
    <input type="submit" value="删" />
  </form>
  <form action="/SpringMvc_war_exploded/handler/testput/修改" method="post" >
    <input type="hidden" name="_method" value="PUT" />
    <input type="submit" value="改" />
  </form>

  <form action="/SpringMvc_war_exploded/handler/testParam" method="post" >
    <input type="text" name="uname" />
    <input type="submit" value="param" />
  </form>

  <form action="/SpringMvc_war_exploded/handler/testRequestHeader" method="post" >
    <input type="submit" value="RequestHeader" />
  </form>

  <form action="/SpringMvc_war_exploded/handler/testCookieValue" method="post" >
    <input type="submit" value="CookieValue" />
  </form>


  <form action="/SpringMvc_war_exploded/handler/testObjectProperties" method="post" >
    id:<input name="id" />
    name:<input name="name" />
    homeaddres:<input name="address.homeaddress" />
    schooladdress:<input name="address.schooladdress" />
    <input type="submit" value="ObjectProperties" />
  </form>

  <a href="handler/testModelAndView">testModelAndView</a>

  <a href="handler/testModelMap">testModelMap</a>
  <a href="handler/testMap">testMap</a>
  <a href="handler/testModel">testModel</a>
  </body>

  <form action="/SpringMvc_war_exploded/handler/testModelAttribute" method="post" >
    id:<input type="hidden" name="id" value="3" />
    name:<input type="text" name="name" />
    <input type="submit" value="ModelAttribute" />
  </form>

  <a href="handler/testMvcViewController">testMvcController</a>


  <form action="/SpringMvc_war_exploded/handler/testConverter" method="post" >
    学生信息:<input type="text" name="StudentInfo"/>
    <input type="submit" value="testConverter" />
  </form>


  <form action="/SpringMvc_war_exploded/handler/testDateTimeFormat" method="post" >
    ID:<input type="text" name="id"/>
    姓名:<input name="name">
    生日:<input name="birthday">
    <input type="submit" value="testDateTimeFormat" />
  </form>
</html>
