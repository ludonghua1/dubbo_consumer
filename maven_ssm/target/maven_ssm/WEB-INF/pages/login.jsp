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
                   url:"${path}/login.shtml",
                   data:{"loginName":loginName,"password":password},
                   success:function(data){
                       if (data=='0'){
                           alert("账户或密码")
                       }else {
                           window.location.href="${path}/index.shtml"
                       }
                   }
               });
           }else {
               alert("账户或密码不能为空！")
           }
        }
       /* function getCookie(Name) {
            var search = Name + "="//查询检索的值
            var returnvalue = "";//返回值
            if (document.cookie.length > 0) {
                sd = document.cookie.indexOf(search);
                if (sd!= -1) {
                    sd += search.length;
                    end = document.cookie.indexOf(";",sd);
                    if (end == -1)
                        end = document.cookie.length;
                    //unescape() 函数可对通过 escape() 编码的字符串进行解码。
                    returnvalue=unescape(document.cookie.substring(sd,end))
                }
            }
            return returnvalue;
        }
        $(document).ready(function () {
            //通过js去查询cookie对应的值
            var loginName = getCookie('loginName');
            var password = getCookie('password');
            document.getElementById("loginName").value=loginName;
            document.getElementById("password").value=password;
            if (loginName!=''||password!=''){
                document.getElementById("rem").cheched=true;
            }
        });*/
    </script>
</head>
<body>
    <center>
        账户：<input type="text" name="loginName" id="loginName"><br>
        密码：<input type="password" name="password" id="password"><br>
        <input type="checkbox" id="rem"/>记住密码
        <button onclick="login()">登录</button>
    </center>
</body>
</html>
