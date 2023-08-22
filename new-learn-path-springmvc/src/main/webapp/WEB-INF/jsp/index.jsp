<%@ page import="com.zufedfc.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/19
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="user" scope="page" class="com.zufedfc.model.User"/>
    <jsp:setProperty name="user" property="name" value="haha"/>

      hello, <jsp:getProperty name="user" property="name"/>


<%

    User user2 = new User();
user2.setName("haha");
%>

hello to you : <%=user2.getName()%>

${user.name}
</body>
</html>
