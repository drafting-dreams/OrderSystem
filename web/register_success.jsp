<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<center>
<table width ="80%">
    <tr>
        <td colspan="2">注册成功</td>
    </tr>
    <tr>
        <td>用户ID：</td>
        <td><%=session.getAttribute("no")%></td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><%=session.getAttribute("uname")%></td>
    </tr>
    <tr>
        <td>密  码：</td>
        <td><%=session.getAttribute("pwd")%></td>
    </tr>
</table>
    <a href="/login">立即登录</a>
</center>
</body>
</html>
