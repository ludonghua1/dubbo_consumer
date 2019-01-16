<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2019/01/07
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修配连汽配市场</title>
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="top2">
    <div class="wid">
        <ul>
            <li class="usename">${user.loginName}&nbsp;&nbsp;&nbsp;&nbsp;${user.username}</li>
            <shiro:hasRole name="admin">
                <li class="shezhi"  onclick="javascript:window.top.document.getElementById('body').src ='${ctx}/index/toChangePassword.shtml'"><a href="javascript:">个人设置</a></li>
            </shiro:hasRole>
            <li>${now}</li>
            <li></li>
            <li class="tuichu" onclick = "javascript:if(confirm('您确定要退出吗？')){window.parent.location.href='${ctx}/logout'}" ><a href="javascript:">退出</a></li>
        </ul>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>
