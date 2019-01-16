<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/30
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>订单展示页面</title>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        // var status =document.getElementById("status");
        // if (status==1){
        //     $("#status").innerHTML="未付款";
        // }
        // if (a==2){
        //     $("#status").innerHTML="已付款";
        // }
        // if (a==3){
        //     $("#status").innerHTML="未发货";
        // }
        // if (a==4){
        //     $("#status").innerHTML="已发货";
        // }
    </script>
</head>
<body>
<center>
    <h2>订单列表</h2>
    <table border="1">
        <tr>
            <th>订单编号</th>
            <th>订单金额</th>
            <th>生成时间</th>
            <th>订单状态</th>
            <th>商品名称</th>

        </tr>
        <c:if test="${!empty list}">
        <c:forEach items="${list}" var="orders">
            <tr>
                <td>${orders.id}</td>
                <td>${orders.money}</td>
                <td>${orders.createTime}</td>
                <td><span id="status">${orders.status}</span></td>
                <td><c:forEach items="${orders.itemsVo}" var="ItemsVo">
                    <p>${ItemsVo.items.itemsName}*${ItemsVo.shoppingCount}*${ItemsVo.items.price}</p>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </c:if>
    </table>
</center>
</body>
</html>
