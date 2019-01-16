<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/21
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="${path}/items/updateItems." method="post">
        <input type="hidden" name="id" value="${list.id}">
        商品价格:<input type="text" name="price" value="${list.price}"><br><br>
        商品名称:<input type="text" name="itemsName" value="${list.itemsName}"><br><br>
        商品库存:<input type="text" name="count" value="${list.count}"><br><br>
        商品图片:<input type="text" name="imgUrl" value="${list.imgUrl}"><br><br>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
