<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2019/01/07
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("ctx",request.getContextPath());%>
<html>
<head>
    <title>修配连汽配市场</title>
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.demo11').Tabs({
                event: 'mouseover'
            });
        });
        function dyniframesize(body) {
            var ifm= document.getElementById("body");

            var subWeb = document.frames ? document.frames["body"].document :

                ifm.contentDocument;

            if(ifm != null && subWeb != null) {

                ifm.height = subWeb.body.scrollHeight;

            }
        }
    </script>
</head>

<body id="cont">
<iframe allowtransparency=true id="top" src="${ctx}/index/top.shtml"  width="100%" height="46px" scrolling="no" frameborder="0"></iframe>
<!--导航-->
<iframe allowtransparency=true  id="navigation" src="${ctx}/index/navigation.shtml" width="100%" height="95px" scrolling="no" frameborder="0"></iframe>
<iframe allowtransparency=true id="body"  src="${ctx}/index/dymsn.shtml" width="100%"  frameborder="0" scrolling="auto" name="body" onload="javascript:dyniframesize('body');"></iframe>
</body>
</html>
