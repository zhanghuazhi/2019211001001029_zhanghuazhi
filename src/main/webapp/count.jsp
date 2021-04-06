<%@ page import="sun.plugin.dom.css.Counter" %><%--
  Created by IntelliJ IDEA.
  User: ECJTU
  Date: 2021/4/6
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>
<body>
<%int count=0; %>
this Page has access : <%out.println(++count);%>
</body>
</html>
