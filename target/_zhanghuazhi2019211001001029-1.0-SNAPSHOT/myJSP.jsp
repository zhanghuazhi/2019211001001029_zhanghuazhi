<%--
  Created by IntelliJ IDEA.
  User: ECJTU
  Date: 2021/3/16
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<a href="http://www.ecjtu.jx.cn/"go to ecjtu ></a><!-- method is GET-->
<form method="get"><!--what is method when we use form?--><!-- its GET ,why? default is GET-->
<!-- its better to use POST in form-->
    Name:<input type ="text" name="name" ><br/>
    ID:<input type="text" name="id" ><br/>
    <input type="submit" value="send data to server"/>

</form>
<%@include file="footer.jsp"%>


</body>
</html>
