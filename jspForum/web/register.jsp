<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: win7x64
  Date: 2017/7/2
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>注册页面</title>
    </head>
    <body>
        <form action="Cregister" method="post">
            账号名 ： <input type="text" name="username"> <br/>
            密码 ： <input type="password" name="password"><br/>

            <input type="submit" value="注册"><br/>
        </form>
        <%= new Date()%>
    </body>

</html>
