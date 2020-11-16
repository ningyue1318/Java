<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/16
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
<form action="${ctp}/testRequestBody" method="post">
    <input name="username" value="tomcat">
    <input name="password" value="123456">
    <input type="submit">
</form>
</body>
</html>
