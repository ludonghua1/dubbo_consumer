<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/21
  Time: 16:27
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
    <form action="${path}/addItems.action" method="post" enctype="multipart/form-data">
        商品价格：<input type="text" name="price">
        商品名称：<input type="text" name="itemsName">
        商品库存：<input type="text" name="count">
        商品图片：<input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
