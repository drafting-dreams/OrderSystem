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
    <title>��ͷ���--��¼</title>
</head>
<body>
<center>
    <h1>��ͷ���--��¼</h1>
    <hr>
    <br>
    <%
        if (session.getAttribute("uname") != null) {
            //�û��ѵ�¼
    %>
    <h2>��¼�ɹ�</h2>
    <h2>
        ��ӭ
        <font color="red" size="12">
            <%=session.getAttribute("uname")%>
        </font>���ٴ˹������
    </h2>
    <h3>
        <a href="/login/menu?status=selectall">������ҳ��</a>
    </h3>
    <%}else{
        //�û�δ��¼����ʾ�û���¼������ת
        response.setHeader("refresh","2;URL=/login");
    %>
    ����δ��¼�����ȵ�¼����
    <br>
    ������Զ���ת����¼���ڣ���
    <br>
    ���û����ת���밴
    <a href="/login">����</a>����
    <%
        }
    %>
</center>
</body>
</html>
