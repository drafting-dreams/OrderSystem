<%@ page import="java.util.*" %>
<%@ page import="vo.Menu" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20
  Time: 23:39
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
        if(session.getAttribute("aname")!=null){
    %>
    <%
        //如果有内容，则修改变量i，如果没有，则根据i的值进行无内容提示
        int i=0;
        String keyword = request.getParameter("keyword");
        List all = null;
        all = (List)request.getAttribute("all");
    %>
    <form action="/admin/menu" method="post">
        <input type="text" name="keyword">
        <input type="hidden" name="status" value="selectbylike">
        <input type="submit" value="查询">
    </form>
    <h3><a href="insert.jsp">添加新菜品</a></h3>
    <table width="80%" border="1">
        <tr>
            <td>食谱id</td>
            <td>菜名</td>
            <td>单价</td>
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

                //因为要关键字返红，所以此处需要接收查询关键字
                if(keyword!=null){
                    name=name.replaceAll(keyword,
                            "<font color=\"red\">"+keyword+"</font>");

                }
        %>
        <tr>
            <td><%=id%></td>
            <td><a href="/admin/menu?id=<%=id%>&status=selectid"><%=name%></a></td>
            <td><%=price%></td>
            <td><a href="/admin/menu?id=<%=id%>&status=delete">删除</a></td>
        </tr>
        <%
            }
            //判断i的值是否改变，如果改变，则表示有内容，反之，无内容
            if(i==0){
        %>
        <tr>
            <td colspan="3">没有任何内容!!!</td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        }else{
           response.setHeader("refresh","2;URL=/admin");
    %>
    您还未登录，请先登录！！
    <br>
    两秒后自动跳转到登录窗口！！
    <br>
    如果没有跳转，请按<a href ="/admin">这里</a>
    <br>
    <%
        }
    %>
</center>
</body>
</html>
