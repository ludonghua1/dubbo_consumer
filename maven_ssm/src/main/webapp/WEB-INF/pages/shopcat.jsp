<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/29
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>购物车</title>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        function check(){
            var array = document.getElementsByName("items");
            var sum = 0;
            for(var i=0;i<array.length;i++){
                if (array[i].checked=true){
                    var price = array[i].parentNode.nextElementSibling.nextElementSibling.innerHTML;
                    var count = array[i].parentNode.parentNode.lastElementChild.innerHTML;
                    var temp = parseInt(price)*parseInt(count);
                    sum+=temp;
                }
            }
        }
        function sumItems(){
            var array=document.getElementsByName("items");
            var sum=0;
            for(var i=0;i<array.length;i++){
                if(array[i].checked==true){
                    //取到的是价格那个单元格的字符串
                    var price=array[i].parentNode.nextElementSibling.nextElementSibling.innerHTML;
                    var count=array[i].parentNode.parentNode.lastElementChild.innerHTML;
                    var temp=parseInt(price)*parseInt(count);
                    sum+=temp;
                }

            }
            var tips=document.getElementById("tips");
            tips.innerHTML=sum+"元"

        }
        function del(){
            var ids="";
            var array=document.getElementsByName("items");
            for(var i=0;i<array.length;i++) {
                if (array[i].checked){
                    ids+=array[i].value+",";
                }
            }
            ids = ids.substring(0,ids.length-1);
            $.ajax({
                    type:"post",
                    url:"${path}/delshopping.shtml",
                    data:{"ids":ids},
                    success:function (data) {
                        //data就是服务端响应的内容
                        if (data=='success') {
                            alert("商品删除成功！");
                            window.location.href="${path}/shoppingCart.shtml";
                        }else {
                            $.ajax({
                                    type:"post",
                                    url:"${path}/delCookieShopping.shtml",
                                    data:{"ids":ids},
                                    success:function (data) {
                                        //data就是服务端响应的内容
                                        if (data=='1') {
                                            alert("商品删除成功!!!");
                                            window.location.href="${path}/shoppinglist.shtml";
                                        }else {

                                        }
                                    }
                                }
                            );

                        }
                    }
                }
            );

        }
        function buyer() {
            var ids = "";
            var array=document.getElementsByName("items");
            for (var i=0;i<array.length;i++){
                if (array[i].checked){
                    ids+=array[i].value+",";
                }
            }
            ids = ids.substring(0,ids.length-1);
            if (ids == "") {
                alert("请选择至少一条数据");
            } else {
                $.ajax({
                    type: 'post',
                    url: '<%=request.getContextPath()%>/makeOrders.shtml',
                    data: {"ids": ids},
                    success: function (data) {
                        if (data == "success") {
                            alert("订单已生成！");
                            window.location.href = "<%=request.getContextPath()%>/toOrders.shtml";
                        }

                    }
                });
            }
        }
    </script>
</head>
<body>
    <center>
        <h2>我的购物车</h2>
        <table border="1">
            <tr>
                <th>商品编号</th>
                <th>商品价格</th>
                <th>商品名称</th>
                <th>商品库存</th>
                <th>商品图片</th>
                <th>商品数量</th>
            </tr>
            <c:if test="${!empty list}">
                <c:forEach items="${list}" var="vo">
                    <tr>
                        <td>${vo.items.id}<input type="checkbox" name="items" onclick="sumItems()" value="${vo.items.id}"></td>
                        <td>${vo.items.itemsName}</td>
                        <td>${vo.items.price}</td>
                        <td>${vo.items.count}</td>
                        <td><img src="${vo.items.imgUrl}" style="height:50px;width:50px"></td>
                        <td>${vo.shoppingCount}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <th colspan="1"><button onclick="check()">全选</button></th>
            <td>总价：<span id="tips"></span></td>
            <th colspan="1"><button onclick="del()">删除</button></th>
            <th colspan="2"><button onclick="buyer()">添加购买</button></th>
        </table>
    </center>
</body>
</html>
