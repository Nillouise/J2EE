<%--
  Created by IntelliJ IDEA.
  User: win7x64
  Date: 2017/7/4
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>productShow</title>
</head>
<body>
<table align='center' border = '1' cellpadding="0">
    <c:forEach items="${productlist}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="addChart?productid=${product.id}">买买买</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
