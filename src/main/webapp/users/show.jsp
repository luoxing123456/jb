<%--
  Created by IntelliJ IDEA.
  User: f
  Date: 4/21/18
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show user info</title>
</head>
<body>
<nav>
    <c:out value="${currentUser.name}"></c:out>
    <a href="/users/logout">注销</a>
</nav>
<h1>show user info</h1>
<p>
    ${user.id}
</p>
</body>
</html>
