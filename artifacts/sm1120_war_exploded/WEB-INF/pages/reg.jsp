<%--
  Created by IntelliJ IDEA.
  User: LJH
  Date: 2018/11/27
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();
    request.setAttribute("path",path);%>
<html>
<head>
    <title>省市县三级联动</title>
    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(document).ready(
            function () {
                $.ajax({
                    //请求类型get、post
                    type:'post',
                    //请求资源路径
                    url:'${path}/getProvince.action',
                    //返回的类型是json类型
                    dataType:'json',
                    success:function(data){
                        //data是json
                        $.each(data,function (index,obj) {
                            var html ="<option value='"+obj.id+"'>"+obj.name+"</option>";
                            //省下拉选追加html
                            $("#province").append(html);
                        });
                    }
                });
            }
        );
        function getCity() {
            //当省 变动的时候，先清空 市和区的所有下拉
            $("#city option[value!=0]").remove();
            $("#county option[value!=0]").remove();
            var id = $("#province").val();
            if (id!='0'){
                $.ajax({
                    type:'post',
                    url:'${path}/getCity.action',
                    //返回的类型是json类型
                    data:{"id":id},
                    dataType:'json',
                    success:function(data){
                        //data是json
                        $.each(data,function (index,obj) {
                            var html ="<option value='"+obj.id+"'>"+obj.name+"</option>";
                            //省下拉选追加html
                            $("#city").append(html);
                        });
                    }
                });
            }
        }
        function getCounty() {
            //当市 变动的时候，先清空区的所有下拉
            $("#county option[value!=0]").remove();
            //获取市的id
            var id = $("#city").val();
            if (id!='0'){
                $.ajax({
                    type:'post',
                    url:'${path}/getCity.action',
                    //返回的类型是json类型
                    data:{"id":id},
                    dataType:'json',
                    success:function(data){
                        //data是json
                        $.each(data,function (index,obj) {
                            var html ="<option value='"+obj.id+"'>"+obj.name+"</option>";
                            //省下拉选追加html
                            $("#county").append(html);
                        });
                    }
                });
            }
        }
    </script>
</head>
<body>
    <center>
        省：<select id="province" onchange="getCity()">
            <option value="0">请选择</option>
        </select>
        市：<select id="city" onchange="getCounty()">
            <option value="0">请选择</option>
        </select>
        县：<select id="county">
            <option value="0">请选择</option>
        </select>
    </center>
</body>
</html>
