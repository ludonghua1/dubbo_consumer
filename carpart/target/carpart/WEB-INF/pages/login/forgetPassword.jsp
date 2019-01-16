<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2019/01/08
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修配连汽配市场</title>
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/layer/layer.min.js" type="text/javascript"></script>
    <script language="javascript">
        function getPwd(){
            var index = parent.layer.getFrameIndex(window.name);
            var email=$("#email").val();
            var username=$("#username").val();
            if(email!=""&&username!=""){
                $.ajax({
                    url:"${ctx}/login/getPassword.shtml",    //请求的url地址
                    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                    data:{"email":email,"loginName":username,},    //参数值
                    type:"post",   //请求方式
                    success:function(data){
                        if(data=='0'){
                            alert("对不起，用户名或邮箱不存在");
                        }else if(data=='1'){
                            alert("恭喜你，新密码已发送到你邮箱");
                            parent.layer.close(index);
                        }

                    },
                });
            }else{

                alert("用户名和邮箱不能为空");
            }
        }
    </script>
</head>
<body>
<div class="password_d"><!--main颜色-->
    <div class="dang">当前位置：找回密码</div>
    <div class="password_f">
        <dl><dt><span style="color:red">*</span>用户名：</dt><dd><input type="text" name="user" id="username" class="in"/></dd><dd>输入您的用户名</dd></dl>
        <dl><dt><span style="color:red">*</span>邮箱：</dt><dd><input type="text" name="email" id="email" class="in"/></dd><dd>输入您注册信息中的email地址</dd></dl>
        <dl style="border:0;"><dt>&nbsp;</dt><dd><input type="button" value="找回密码" class="pa" onclick="getPwd()" /></dd></dl>
    </div>
</div>
</body>
</html>
