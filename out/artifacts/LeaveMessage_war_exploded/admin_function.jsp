<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>菜单管理</h1>
    <hr>
    <br>
    <%
        if (session.getAttribute("aname") != null) {
            //用户已登录
    %>
    <h2>登录成功</h2>
    <h2>
        欢迎
        <font color="red" size="12">
            <%=session.getAttribute("aname")%>
        </font>光临此管理程序
    </h2>
    <h3>
        <a href="/admin/menu?status=selectall">进入管理页面</a>
    </h3>
    <%}else{
        //用户未登录，提示用户登录，并跳转
        response.setHeader("refresh","2;URL=/admin");
    %>
    您还未登录，请先登录！！
    <br>
    两秒后自动跳转到登录窗口！！
    <br>
    如果没有跳转，请按
    <a href="/login">这里</a>！！
    <%
        }
    %>
</center>
</body>
</html>
