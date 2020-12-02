<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/14
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello.jsp</h1>
    <%
        request.setAttribute("arr",new String[]{"123","456","789"});
    %>

    <c:forEach items="${arr}" var="i">
        ${i}<br>
    </c:forEach>
</body>
</html>
