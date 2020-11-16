<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/11/16
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<%=new Date()%>
    <a href="${ctp}/getallajax">ajax获取所有的员工</a>
<div>
</div>

<script type="text/javascript">
    $("a:first").click(function () {
        $.ajax({
            url:"${ctp}/getallajax",
            type:"GET",
            success:function (data) {
              $.each(data,function () {
                  var empinfo = "-->";
                  $("div").append(empinfo);
              });
            }
        });
        return false;
    })
</script>
</body>
</html>
