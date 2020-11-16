<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/15
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工添加</title>
</head>
<body>
<h1 >员工添加</h1>
<!--
<form action="">
    lastName:<input type="text" name="lastName"></br>
    email:<input type="text" name="email"></br>
    gender:<br/>
         男：<input type="radio" name="gender" value="1"></br>
         女：<input type="radio" name="gender" value="0"></br>
    dept：
         <select name="department.id">
             <c:forEach items="${depts}" var="deptItem">
                 <option  value="${deptItem.id}">${deptItem.departmentName}</option>
             </c:forEach>
         </select>
    <input type="submit" value="提交">
</form>
-->
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<form:form action="${ctp}/emp" modelAttribute="employee" method="post">
    lastName:<form:input path="lastName"/><br/>
    email:<form:input path="email"/><br/>
    gender:<br/>
        男：<form:radiobutton path="gender" value="1"/><br/>
        女：<form:radiobutton path="gender" value="0"/><br/>
    birth:<form:input path="birth"/><br/>
    dept：<form:select path="department.id" items="${depts}"
                      itemLabel="departmentName" itemValue="id"/>
    <input type="submit" value="保存">
</form:form>
</body>
</html>
