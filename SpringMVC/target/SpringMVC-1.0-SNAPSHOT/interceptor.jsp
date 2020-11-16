<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/16
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
    <a href="${ctp}/test01">test01</a><br/>
    <a href="${ctp}/handleException?i=0">测试异常</a><br/>
    <a href="${ctp}/handleException2?username=admin">测试异常</a><br/>
    <a href="${ctp}/handleException3">测试异常3</a><br/>
</body>
</html>
