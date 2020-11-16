<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/16
  Time: 10:50
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
${msg}
<form action="${ctp}/upload" method="post" enctype="multipart/form-data">
    用户头像:<input type="file" name="headerimg"><br/>
    用户名:<input type="text" name="username"><br/>
    <input type="submit">
</form>
</body>
</html>
