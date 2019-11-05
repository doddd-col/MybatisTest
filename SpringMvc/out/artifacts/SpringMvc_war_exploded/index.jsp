
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
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
  </body>
</html>
