<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/12/9
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询了所有的信息</h3>
<c:forEach items="${list}" var="user">
${user.username}
</c:forEach>
</body>
</html>
