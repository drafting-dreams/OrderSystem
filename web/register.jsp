<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/19
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<center>
<h1>注册</h1>
<hr>
<br>
<form action="/register" method="post">
    <table width="80%">
        <tr>
            <td colspan="2">用户注册</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="id"> </td>
        <tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name"> </td>
        <tr>
            <td>密&nbsp;&nbsp;码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
        </tr>
    </table>
</form>
</center>
</body>
</html>
