<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/15
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工修改页面</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
    <h1>员工修改页面</h1>
    <form:form action="${ctp}/emp/${employee.id}" modelAttribute="employee" method="post">
        <input type="hidden" name="_method" value="put"/>
        <input type="hidden" name="id" value="${employee.id}"/>
        email:<form:input path="email"/><br/>
        gender:&nbsp;&nbsp;&nbsp;
            男:<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
            女:<form:radiobutton path="gender" value="0"/><br/>
        dept:
            <form:select path="department.id" items="${depts}"
            itemLabel="departmentName" itemValue="id"/>
        <input type="submit" value="修改">
    </form:form>
</body>
</html>
