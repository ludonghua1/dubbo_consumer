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
    <link rel="stylesheet" href="${path}/css/style.css" type="text/css">
</head>
<body>
<center>
    <form action="${path}/items/addItems." method="post" enctype="multipart/form-data">
        商品价格：<input type="text" name="price"><br>
        商品名称：<input type="text" name="itemsName"><br>
        商品库存：<input type="text" name="count"><br>
        商品图片：<input type="file" name="file"><br>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
