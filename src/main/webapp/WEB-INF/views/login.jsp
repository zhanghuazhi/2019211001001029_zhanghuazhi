<%--
  Created by IntelliJ IDEA.
  User: ECJTU
  Date: 2021/4/20
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVale="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }if (c.getName().equals("cRememberMe")){
                rememberMeVale=c.getValue();
            }
        }
    }
%>
<form method="post" action="/2019211001001029zhanghuazhi_war_exploded/login">
    <table>
        Username:<input type="text" name="Username" value="<%=username%>"><br/>
        password:<input type="password" name="password" value="<%=password%>"><br/>
        <input type="checkbox"name="rememberMe" value="1" <%=rememberMeVale.equals("1") ?"checked":""%>checked/>RememberMe<br/>
        <input type="submit" value="Submit"/>
    </table>
</form>
   
<%@include file="footer.jsp"%>