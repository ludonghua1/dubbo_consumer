<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/12/17
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
  request.setAttribute("path",path);%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${path}/toLogin.">请登录</a>
  </body>
</html>
