<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/12/14
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="${path}/css/style.css" type="text/css">
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        function reg() {
            var loginName = document.getElementsByName("loginName")[0].value;
            var password = document.getElementsByName("password")[0].value;
            var password1 = document.getElementsByName("password")[1].value;
            if (loginName==""||password==""){
                alert("账户或密码不能为空！");
            }else if(password!=password1){
                alert("两次密码输入不一致！")
            }else {
                $.ajax({
                    type:"post",
                    url:"${path}/login.",
                    data:{"loginName":loginName,"password":password},
                    success:function(data){
                        if (data=='1'){
                            alert("账户已存在！")
                        }else {
                        window.location.href="${path}/reg.";
                        }
                    }
                });
            }
        }

    </script>
</head>
<body>
    <center>
        账户：<input type="text" name="loginName"><br>
        密码：<input type="password" name="password"><br>
        新密码：<input type="password" name="password"><br>
        <input type="button" value="提交" onclick="reg()">
    </center>
</body>
</html>
