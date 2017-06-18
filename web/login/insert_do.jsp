<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="vo.Order" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/22
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订餐成功</title>
</head>
<body>
<center>
    <%
        request.setCharacterEncoding("UTF-8");
        boolean b =((Boolean)request.getAttribute("flag")).booleanValue();
        if (session.getAttribute("uname") != null) {
            //用户已登录
            if(b){
    %>
    <%
        //如果有内容，则修改变量i，如果没有，则根据i的值进行无内容提示
        int i=0;
        List all = null;
        all = (List)request.getAttribute("all");
    %>
    <h2>订餐成功，以下是您的订单信息</h2>
    <table width="80%" border="1">
        <tr>
            <td>用户id</td>
            <td>菜名</td>
            <td>数量</td>
            <td>金额</td>
            <td>订单日期</td>
        </tr>
        <%
            Iterator iter = all.iterator();
            while (iter.hasNext()) {
                Order order = (Order)iter.next();
                i++;
                //进行循环打印，打印出所有的内容，以表格形式从数据库中取出内容
                String userId=order.getUserId();
                String mname=order.getMenuName();
                int number=order.getNum();
                float money=order.getMoney();
                Date date=new Date();
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = format.format(date);
        %>
        <tr>
            <td><%=userId%></td>
            <td><%=mname%></td>
            <td><%=number%></td>
            <td><%=money%></td>
            <td><%=dateString%></td>
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
        }
    %>
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
