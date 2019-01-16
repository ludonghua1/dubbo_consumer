<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/21
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();
    request.setAttribute("path",path);%>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        function getCookie(Name) {
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
        function sub() {
            var loginName =$("#loginName").val();
            var password =$("#password").val();
            var rem = document.getElementById("rem").checked;
            if (loginName!=''&&password!=''){
                $.ajax({
                    //请求类型get、post
                    type:"post",
                    //请求资源路径
                    url:"${path}/login.action",
                    //参数
                    data:{"loginName":loginName,"password":password,"rem":rem},
                    //data:'{"loginName":"'+loginName+'","password":"'+password+'"}',
                    //contentType:"application/json;charset=utf-8",
                    //回调函数，服务端地址将响应的数据回调给回调函数
                    success:function (data) {
                        //data就是服务端响应的内容
                        if (data=='0'){
                            $("#tips").html("登录名或密码错误！");
                        }else {
                            window.location.href="${path}/index.action";
                        }
                    }
                });
            }else {
                alert("用户名或密码不能为空！");
            }
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
        });
    </script>
</head>
<body>
<center>
    登录名：<input type="text" name="loginName" id="loginName"><br><br>
    密码：<input type="password" name="password" id="password"><br><br>
    <button onclick="sub()">登录</button><span id="tips" style="color: red"></span>
    <input type="checkbox" id="rem"/>记住密码
</center>
</body>
</html>
