<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/21
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点餐系统</title>
</head>
<body>
<center>
    <h1>点餐系统</h1>
    <hr>
    <br>
    <%
        //进行乱码处理
        request.setCharacterEncoding("UTF-8");
    %>
    <%
        if (session.getAttribute("aname") != null) {
     %>
    <%
        response.setHeader("refresh", "2;URL=menu?status=selectall");
        boolean b=((Boolean)request.getAttribute("flag")).booleanValue();
        if(b){
    %>
    添加成功，两秒后跳到食谱列表页！！！
    <br>
    如果没有跳转，请按<a href="/admin/menu?status=selectall">这里</a>!!!
    <%
        }
    %>

    <%
        }else{
            //用户未登录，提示用户登录，并跳转
            response.setHeader("refresh","2;URL=/admin");
    %>
    您还未登录，请先登录！！！
    <br>
    两秒后自动跳转到登录窗口！！！
    <br>
    如果没有跳转，请按<a href="/login">这里</a>！！！
    <br>
    <%
        }
    %>
</center>
</body>
</html>
