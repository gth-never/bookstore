<%--
  Created by IntelliJ IDEA.
  User: never
  Date: 17-3-20
  Time: 下午1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登陆</title>
</head>
<body>
    <form action="/bookstore/login" method="post">
        <input type="hidden" name="userId" value="-1">
        用户名:<input type="text" name="userName"><br>
        密&nbsp;码:<input type="password" name="password"><br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
