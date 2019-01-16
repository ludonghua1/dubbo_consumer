<%--
  Created by IntelliJ IDEA.
  User: cuijinke
  Date: 2018/12/27
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>抢购秒杀</title>
    <style type="text/css">
        .time-item strong {
            background: #C71C60;
            color: #fff;
            line-height: 49px;
            font-size: 36px;
            font-family: Arial;
            padding: 0 10px;
            margin-right: 10px;
            border-radius: 5px;
            box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2);
        }

        .day_show .unit {
            float: left;
            line-height: 49px;
            color: #c71c60;
            font-size: 32px;
            margin: 0 10px;
            font-family: Arial, Helvetica, sans-serif;
        }

        .item-title .unit {
            background: none;
            line-height: 49px;
            font-size: 24px;
            padding: 0 10px;
            float: left;
        }
    </style>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/js/jquery-ui-jqLoding.js"></script>
    <script type="text/javascript">
        <%--var intDiff = parseInt('${itemsVo.leftTime}'); //倒计时总秒数量--%>
        //同步商品id和抢购开始时间
        var array = new Array();
        var array1 = new Array();
        <c:forEach items="${list}" var="itemsVo">
            array.push(${itemsVo.items.id});//js中可以使用此标签，将EL表达式中的值push到数组中
            array1.push(${itemsVo.leftTime});
        </c:forEach>
        function timer(idName,leftTime) {
            window.setInterval(function () {
                var day = 0,
                    hour = 0,
                    minute = 0,
                    second = 0; //时间默认值
                if (leftTime > 0) {
                    day = Math.floor(leftTime / (60 * 60 * 24));
                    hour = Math.floor(leftTime / (60 * 60)) - (day * 24);
                    minute = Math.floor(leftTime / 60) - (day * 24 * 60) - (hour * 60);
                    second = Math.floor(leftTime) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
                }
                if (minute <= 9) minute = '0' + minute;
                if (second <= 9) second = '0' + second;
                $(idName+' .day_show').html(day + "天");
                $(idName+' .hour_show').html('<s id="h"></s>' + hour + '时');
                $(idName+' .minute_show').html('<s></s>' + minute + '分');
                $(idName+' .second_show').html('<s></s>' + second + '秒');
                if(leftTime==0){
                    window.location.reload();
                }
                leftTime--;
            }, 1000);
        }
        $(function () {
            for(var i=0;i<array.length;i++){
                timer('#interval'+array[i],array1[i]);
            }
//            timer(intDiff);
        });
        function fastSale(itemsId) {
            var id = itemsId;
            var leftTime;
            for(var i=0;i<array.length;i++){
                if(array[i]==itemsId){
                    leftTime = Number(array1[i]);
                }
            }
            if (leftTime > 0) {
                alert("活动还未开始")
            } else {
                $.ajax({
                    type: "post",
                    url: "${path}/flashSale.shtml",
                    data: {"id": id},
                    success: function (data) {
                        //不管成功不成功 ，这里都得提示
                        if (data == '2') {
                            alert("恭喜你抢购成功");
                            //$(this).jqLoading("destroy");
                            window.location.href = "${path}/flashSaleOrders.shtml?id=" + id;
                        } else if (data == '1') {
                            //$(this).jqLoading("destroy");
                            alert("已抢完");
                        } else if (data == '0') {
                            //$(this).jqLoading("destroy");
                            alert("活动没开始");
                        } else if(data=='3'){
                            //$(this).jqLoading("destroy");
                            alert("你已经抢过该商品了");
                            window.location.href = "${path}/flashSaleOrders.shtml?id=" + id;
                        }
                    }
                });
                //$(this).jqLoading();
            }
        }
    </script>
</head>
<body>
<center>
    <c:if test="${msg==0}"><h2>暂无此类活动</h2></c:if>
    <c:if test="${msg==1}">
        <h2 style="color:orange;font-weight: bolder;font-size: 28px">抢购秒杀!!!</h2>
        <c:forEach items="${list}" var="itemsVo">
            <div>
                <table>
                    <tr style="height: 150px"><td style="width:200px"><img src="${itemsVo.items.imgUrl}" style="height: 150px;width:200px"></td></tr>
                    <tr><td>商品名称：${itemsVo.items.itemsName}</td></tr>
                    <tr><td>商品价格：<font style="color: red;font-size: 36px;font-weight: bold">${itemsVo.items.price}元</font></td></tr>
                    <tr><td>总库存：<font style="color: orange;font-size: 28px;font-weight: bold">${itemsVo.count}</font>件</td></tr>
                    <tr><td>剩余库存：<font style="color: orange;font-size: 36px;font-weight: bold">${itemsVo.leftCount}</font>件</td></tr>
                </table>
            </div>
            <!--倒计时模块-->
            <div id="interval${itemsVo.items.id}" class="time-item">
                <strong class="day_show">0天</strong>
                <strong class="hour_show">0时</strong>
                <strong class="minute_show">0分</strong>
                <strong class="second_show">0秒</strong>
            </div>
            <br/>
            <div>
                <button onclick="fastSale(${itemsVo.items.id})">抢购</button>
            </div>
        </c:forEach>
    </c:if><br/>
    <a href="${path}/index.shtml">返回管理界面</a>
</center>
</body>
</html>
