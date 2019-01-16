<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/12/06
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>Title</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <center>
        <h3>资源列表</h3>
        <table border="1">
           <tr>
               <th>资源名</th>
           </tr>
           <c:forEach items="${files}" var="file">
               <tr>
                   <td><a href="${path}/download1.action?filename=${file.name}">${file.name}</a></td>
               </tr>
           </c:forEach>
            <a href="${path}/index.action">返回</a>
        </table>
    </center>
</body>
</html>
