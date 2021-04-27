<%--
  Created by IntelliJ IDEA.
  User: ECJTU
  Date: 2021/4/20
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="zhz.model.User" %>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp" %>
<h1>User Info</h1>
<%
     //read cookies
    Cookie [] allCookies=request.getCookies();
    for (Cookie c:allCookies){
        //get one by one
        out.println("<br/"+c.getName()+" --- "+c.getValue());
    }
%>
<%
    User u=(User) session.getAttribute("user");
%>

<table border="1" >
    <tr>
        <td>Username</td><td><%=u.getUsername()%></td>
    </tr><tr>
    <td>Password</td><td><%=u.getPassword()%></td>
</tr><tr>
    <td>Email</td> <td><%=u.getEmail()%></td>
</tr><tr>
    <td>Gender</td><td><%=u.getGender()%></td>
</tr><tr>
    <td>Birthdate</td> <td><%=u.getBirthdate()%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>
