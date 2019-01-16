<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/20
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();
  request.setAttribute("path",path);%>
<html>
  <head>
    <title>$Title$</title>
    <style>
      span{
        color:red;
        font-size: 20px;
      }
      a{
        color: black;
        text-decoration: none;
      }
      a:hover{
        color: blue;
      }
    </style>
  </head>
  <body>
  <center>
    <h5>欢迎<span>${user.loginName}</span>登录</h5>
    <c:if test="${not empty user}">
        <a href="${path}/list.action">商品管理</a><br>
        <a href="${path}/shoppinglist.action">用户购物车</a><br>
        <a href="${path}/toOrders.action">订单管理</a><br>
        <a href="${path}/toReg.action">用户注册</a><br>
        <a href="">用户管理</a><br>
        <a href="${path}/toupload.action">上传资源</a><br>
        <a href="${path}/todownload.action">下载资源</a><br>
    </c:if>
    <c:if test="${empty user}">
        <a href="${path}/list.action">商品管理</a><br>
        <a href="${path}/shoppinglist.action">用户购物车</a><br>
    </c:if>
  </center>
  </body>
</html>
