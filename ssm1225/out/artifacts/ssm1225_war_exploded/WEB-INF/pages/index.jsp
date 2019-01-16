<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/12/25
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
  request.setAttribute("path",path);%>
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" href="${path}/css/style.css" type="text/css">
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        function select() {
            //var ipP = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
            var ip= "";
            var ip = $("#ip").val();
            if (ip!=null&&ip!=''){
                $.ajax({
                    type:"post",
                    url:"${path}/homeLocation.shtml",
                    data:{"ip":ip},
                    success:function(data){
                        if (data!=null&&data!=""){
                           $("#result").html(data);
                        }
                    }
                });
            }else {
                alert("ip不能为空！");
            }
        }
    </script>
  </head>
  <body>
    <center>
      <a href="${path}/items/itemsList.shtml">商品列表</a><br>
      <a href="${path}/shoppingCart.shtml">我的购物车</a><br>
      <a href="${path}/toFlashSale.shtml">抢购秒杀</a><br>
      <input type="text" id="ip" >
      <button onclick="select()">查询</button><br>
      <strong id="result"></strong>
    </center>
  </body>
</html>
