<%--
  Created by IntelliJ IDEA.
  User: cuijinke
  Date: 2018/12/28
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>orders</title>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(document).ready(function () {
            var status = document.getElementById("status");
            if (status.innerHTML == "1") {
                status.innerHTML = "未付款";
            } else if (status.innerHTML == "2") {
                status.innerHTML = "已付款";
            } else if (status.innerHTML == "3") {
                status.innerHTML = "发货中";
            }
        });
    </script>
</head>
<body>
<center>
    <h3>订单列表</h3>
    <table border="1">
        <tr align="center">
            <td>订单号</td>
            <td>订单金额</td>
            <td>订单时间</td>
            <td>订单状态</td>
            <td>商品列表</td>
        </tr>
        <tr align="center">
            <td id="ordersId">${orders.id}</td>
            <td>${orders.money}</td>
            <td><fmt:formatDate value="${orders.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><span id="status">${orders.status}</span></td>
            <td>
                <p>${orders.itemsVo.items.itemsName}*${orders.itemsVo.shoppingCount}</p>
            </td>
        </tr>
    </table>
    <br/>
    <%--    <button onclick="buy();">付款</button>&nbsp;&nbsp;&nbsp;
        <button onclick="toShop();">返回购物车</button>&nbsp;&nbsp;&nbsp;
        <button onclick="selMyOrders();">查询我的所有订单</button>--%>
</center>
</body>
</html>
