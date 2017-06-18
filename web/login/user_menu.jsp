<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="vo.Menu" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/22
  Time: 10:45
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
        request.setCharacterEncoding("UTF-8");
        if(session.getAttribute("uname")!=null){
    %>
    <%
        //如果有内容，则修改变量i，如果没有，则根据i的值进行无内容提示
        int i=0;
        String keyword = request.getParameter("keyword");
        List all = null;
        all = (List)request.getAttribute("all");
    %>

    <table width="80%" border="1">
        <tr>
            <td>食谱id</td>
            <td>菜名</td>
            <td>单价</td>
            <td>数量</td>
        </tr>
        <%
            Iterator iter = all.iterator();
            while (iter.hasNext()) {
                Menu menu = (Menu)iter.next();
                i++;
                //进行循环打印，打印出所有的内容，以表格形式从数据库中取出内容
                String id = menu.getId();
                String name=menu.getName();
                float price=menu.getPrice();
                String stringPrice = name + "price";
                String stringNumber=name+"number";
                String stringIndex=name+"index";

                //因为要关键字返红，所以此处需要接收查询关键字
                if(keyword!=null){
                    name=name.replaceAll(keyword,
                            "<font color=\"red\">"+keyword+"</font>");

                }
        %>
        <form action="/login/menu" method="post">
        <tr>
            <td><%=id%><input type="hidden" name=<%=id%> value=<%=id%>></td>
            <td><%=name%><input type="hidden" name=<%=name%> value=<%=name%>></td>
            <td><%=price%><input type="hidden" name=<%=stringPrice%> value=<%=price%>></td>
            <td><input type="text" name=<%=stringNumber%>></td>
            <input type="hidden" name="status" value="insert"/>
            <input type="hidden" name=<%=stringIndex%> value=<%=i%>>
        </tr>

        <%
            }
        %>
            <tr>
                <td colspan="3">
                    <input type="submit" value="提交订单">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </form>
        <%
            //判断i的值是否改变，如果改变，则表示有内容，反之，无内容
            if(i==0){
        %>
        <tr>
            <td colspan="4">没有任何内容!!!</td>
        </tr>
        <%
            }
        %>
    </table>
    <%
    }else{
        response.setHeader("refresh","2;URL=/login");
    %>
    您还未登录，请先登录！！
    <br>
    两秒后自动跳转到登录窗口！！
    <br>
    如果没有跳转，请按<a href ="/login">这里</a>
    <br>
    <%
        }
    %>
</center>
</body>
</html>
