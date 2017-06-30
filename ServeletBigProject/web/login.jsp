<%--
  Created by IntelliJ IDEA.
  User: win7x64
  Date: 2017/6/30
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="/login" method="post">
        账号: <input type="text" name="name"> <br>
        密码: <input type="password" name="password"> <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
