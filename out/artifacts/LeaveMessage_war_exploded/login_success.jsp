<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/18
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title>点餐服务--登录</title>
</head>
<body>
<center>
    <h1>点餐服务--登录</h1>
    <hr>
    <br>
    <%
        if (session.getAttribute("uname") != null) {
            //用户已登录
    %>
    <h2>登录成功</h2>
    <h2>
        欢迎
        <font color="red" size="12">
            <%=session.getAttribute("uname")%>
        </font>光临此管理程序
    </h2>
    <h3>
        <a href="/login/menu?status=selectall">进入点餐页面</a>
    </h3>
    <%}else{
        //用户未登录，提示用户登录，并跳转
        response.setHeader("refresh","2;URL=/login");
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
