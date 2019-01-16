<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2019/01/07
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修配连汽配市场</title>
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery-1.7.1.min.js"></script>
    <!--tab切换-->
    <script src="${ctx}/js/jquery.tabs.js"></script>
    <script>
        function Goto(src) {
            window.top.document.getElementById('body').src = src;

        }
    </script>
</head>
<body>
<div class="top3">
    <!--导航-->
    <div class="wid">
        <div class="top3_left">
            <span>修配连</span>汽配市场
        </div>
        <div class="top3_right">
            <!--导航-->
            <c:if test="${not empty menuList}">
                <ul id="test">
                    <c:forEach var="menu" items="${menuList}"
                               varStatus="status">
                        <c:if test="${menu.parentId==1}">

                            <li  onclick="Goto('${ctx}/${menu.url}')">
                                <div class="top">
                                    <!-- 展示该菜单所对应的logo -->
                                    <img src="${ctx}/${menu.image}" />
                                </div>
                                <!-- 展示该菜单的名字等信息 -->
                                <div class="bottom">${menu.menuName}</div>
                            </li>
                        </c:if>

                    </c:forEach>

                </ul>
            </c:if>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>
