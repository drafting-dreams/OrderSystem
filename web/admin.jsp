<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<center>
    <h1>管理员</h1>
    <hr>
    <br>
    <%
        //判断是否有错误信息，如果有，则打印
        //如果没有此段代码，则显示时会直接打印null
        if (request.getAttribute("err") != null) {
    %>
    <h2><%=request.getAttribute("err")%></h2>
    <%
        }
    %>
    <form action="/admin" method="post">
        <table width="80%">
            <tr>
                <td colspan="2">管理员登录</td>
            </tr>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>

</center>
</body>
</html>
