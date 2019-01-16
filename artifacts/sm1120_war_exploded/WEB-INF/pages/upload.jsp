<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/12/06
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>上传资源</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <center>
        <form action="${path}/upload.action" method="post" enctype="multipart/form-data">
            <h3>资源上传</h3>
            <input type="file" name="file"><br>
            <input type="submit" value="上传"><br>
            <a href="${path}/todownload.action">下载资源</a>
        </form>
    </center>
</body>
</html>
