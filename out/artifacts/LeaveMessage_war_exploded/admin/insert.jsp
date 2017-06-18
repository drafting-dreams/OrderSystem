<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/21
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>
<body>
<center>
    <h1>菜单管理</h1>
    <hr>
    <br>
    <%
        if(session.getAttribute("aname")!=null){
            //用户已登录
    %>
    <form action="/admin/menu" method="post">
        <table>
            <tr>
                <td colspan="2">添加新菜品</td>
            </tr>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="mno"></td>
            </tr>
            <tr>
                <td>菜名:</td>
                <td><input type="text" name="mname"></td>
            </tr>
            <tr>
                <td>单价:</td>
                <td><input type="text" name="mprice"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="status" value="insert"/>
                    <input type="submit" value="添加">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
    <%
        }else{
            //用户未登录，提示用户登录，并跳转
            response.setHeader("refresh","2;URL=/admin");
    %>
    您还未登录，请先登录！！！
    <br>
    两秒后自动跳转到登录窗口！！！
    <br>
    如果没有跳转，请按<a href="/admin">这里</a>！！！
    <br>
    <%
        }
    %>
</center>
</body>
</html>
