<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/12/13
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
   request.setAttribute("path",path);%>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="${path}/css/style.css" type="text/css">
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        function login() {
           var loginName = $("#loginName").val();
           var password = $("#password").val();
           if (loginName!=''&&password!=''){
               $.ajax({
                   type:"post",
                   url:"${path}/login.",
                   data:{"loginName":loginName,"password":password},
                   success:function(data){
                       if (data=='0'){
                           alert("账户或密码")
                       }else {
                           window.location.href="${path}/items/itemsList."
                       }
                   }
               });
           }else {
               alert("账户或密码不能为空！")
           }
        }
        function reg() {
            window.location.href="${path}/toReg."
        }
    </script>
</head>
<body>
    <center>
        账户：<input type="text" name="loginName" id="loginName"><br>
        密码：<input type="password" name="password" id="password"><br>
        <button onclick="login()">登录</button>
        <button onclick="reg()">注册</button>
    </center>
</body>
</html>
