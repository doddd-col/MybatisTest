<%--
  Created by IntelliJ IDEA.
  User: 提拉米苏
  Date: 2019/11/4
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<C:forEach items="${requestScope.cuowu}" var="cuo">
    ${cuo.getDefaultMessage()}
</C:forEach>
<br />
    welcome to spring mvc<br />
    ${requestScope.student.id}-${requestScope.student.name}-${requestScope.student.address.homeaddress}-${requestScope.student.address.schooladdress}<br />
    ${requestScope.student2.id}-${requestScope.student2.name}-${requestScope.student2.address.homeaddress}-${requestScope.student2.address.schooladdress}<br />
    ${requestScope.student3.id}-${requestScope.student3.name}-${requestScope.student3.address.homeaddress}-${requestScope.student3.address.schooladdress}<br />
    ${requestScope.student4.id}-${requestScope.student4.name}-${requestScope.student4.address.homeaddress}-${requestScope.student4.address.schooladdress}<br />

-----Session<br />
    ${sessionScope.student.id}-${sessionScope.student.name}-${sessionScope.student.address.homeaddress}-${sessionScope.student.address.schooladdress}<br />
    ${sessionScope.student2.id}-${sessionScope.student2.name}-${sessionScope.student2.address.homeaddress}-${sessionScope.student2.address.schooladdress}<br />
    ${sessionScope.student3.id}-${sessionScope.student3.name}-${sessionScope.student3.address.homeaddress}-${sessionScope.student3.address.schooladdress}<br />
    ${sessionScope.student4.id}-${sessionScope.student4.name}-${sessionScope.student4.address.homeaddress}-${sessionScope.student4.address.schooladdress}<br />



</body>
</html>
