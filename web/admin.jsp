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
    <title>����Ա��¼</title>
</head>
<body>
<center>
    <h1>����Ա</h1>
    <hr>
    <br>
    <%
        //�ж��Ƿ��д�����Ϣ������У����ӡ
        //���û�д˶δ��룬����ʾʱ��ֱ�Ӵ�ӡnull
        if (request.getAttribute("err") != null) {
    %>
    <h2><%=request.getAttribute("err")%></h2>
    <%
        }
    %>
    <form action="/admin" method="post">
        <table width="80%">
            <tr>
                <td colspan="2">����Ա��¼</td>
            </tr>
            <tr>
                <td>�˺ţ�</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>��&nbsp;&nbsp;��</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="��¼"/>
                    <input type="reset" value="����"/>
                </td>
            </tr>
        </table>
    </form>

</center>
</body>
</html>
