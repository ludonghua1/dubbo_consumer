<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/20
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
   request.setAttribute("path",path);%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        function check(){
            var array=document.getElementsByName("items");
            for(var i=0;i<array.length;i++){
                array[i].checked=true;
            }
        }

        function onSave(){
            var array=document.getElementsByName("items");
            for(var i=0;i<array.length;i++) {
                array[i].checked = !(array[i].checked);
            }

        }
        function sumItems(){
            var array=document.getElementsByName("items");
            var sum=0;
            for(var i=0;i<array.length;i++){
                if(array[i].checked==true){
                    var price=array[i].parentNode.nextElementSibling.nextElementSibling.innerHTML;
                    sum+=parseInt(price);
                }

            }
            var tips=document.getElementById("tips");
            tips.innerHTML=sum+"元"

        }
        function shopping(){
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
                    url:"${path}/shopping.action",
                    data:{"ids":ids},
                    success:function (data) {
                        //data就是服务端响应的内容
                        if (data=='success') {
                            alert("商品添加成功！");
                            window.location.href="${path}/shoppingCart.action";
                        }else{
                            $.ajax({
                                    type:"post",
                                    url:"${path}/cookie.action",
                                    data:{"ids":ids},
                                    success:function (data) {
                                        //data就是服务端响应的内容
                                        if (data=='1') {
                                            alert("aaaaa");
                                            window.location.href="${path}/shoppinglist.action";
                                        }
                                    }
                                }
                            );
                        }
                    }
                }
            );

        }
    </script>
</head>
<body>
<center>
    <form action="${path}/likeItems.action">
        商品名称: <input type="text" name="itemsName">
        商品价格: <input type="text" name="price">
        <input type="submit" value="提交">
    </form>
    <table border="1">
        <tr>
            <th></th>
            <th>商品编号</th>
            <th>商品价格</th>
            <th>商品名称</th>
            <th>商品库存</th>
            <th>商品图片</th>
            <c:if test="${not empty user}">
                <th colspan="2"><a href="${path}/toAddItems.action">增加</a></th>
            </c:if>
        </tr>
        <c:forEach items="${list}" var="items">
            <tr>
                <th><input type="checkbox" name="items" onclick="sumItems()" value="${items.id}"></th>
                <td>${items.id}</td>
                <td>${items.price}</td>
                <td>${items.itemsName}</td>
                <td>${items.count}</td>
                <td><img src="${items.imgUrl}"style="width: 40px;height: 40px" alt=""></td>
                <c:if test="${not empty user}">
                    <td><a href="<%=request.getContextPath()%>/deleteItems.action?id=${items.id}">删除</a></td>
                    <td><a href="<%=request.getContextPath()%>/modifyItems.action?id=${items.id}">修改</a></td>
                </c:if>
            </tr>
        </c:forEach>
        <th colspan="1"><button onclick="check()"  >全选</button></th>
        <th colspan="1"><button onclick="onSave()" >反选</button></th>
        <th colspan="1">总价：<span id="tips"></span></th>
        <th colspan="1"><button onclick="shopping()">加入购物车</button></th>
    </table>
</center>
</body>
</html>
