<%--
  Created by IntelliJ IDEA.
  User: win7x64
  Date: 2017/7/2
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="Model2.Muserinfo" %>
<%-- handnote --%>
<%-- 从jstl包中导入实用的jsp标签,用c命名 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>userinfo</title>
</head>
<body>
<%--<%--%>
    <%--List<Muserinfo> list = (List<Muserinfo>) request.getAttribute("userinfolist");--%>
    <%--for( Muserinfo i : list)--%>
    <%--{--%>
        <%--System.out.println(i.toString() );--%>
    <%--}--%>


<%--%>--%>

<%-- handnote 这里用"_"代替"."，是因为"."才符合EL表达式的规范。 --%>
    总用户数：${muserinfo_getCount} <br/>

    <c:forEach items="${userinfolist}" var="userinfo" varStatus="st">
        <tr>
            <td>${userinfo.id}</td>
            <td>${userinfo.username}</td>
            <td>${userinfo.password}</td>
            <td>${userinfo.createtime}</td>
            <td><a href="editHero?id=${userinfo.id}">edit</a></td>
            <td><a href="deleteHero?id=${userinfo.id}">delete</a></td>
        </tr>
    </c:forEach>
</body>
</html>
