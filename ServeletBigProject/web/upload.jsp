<%--
  Created by IntelliJ IDEA.
  User: win7x64
  Date: 2017/7/1
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<%-- handnote  上传文件的页面--%>
<%-- 下面这个multipart/form-data 和 post（一定要是post才能上传二进制数据），确保是上传文件 --%>
<p>上传文件（以二进制的方式上传</p>
<form action="uploadPhoto" method="post" enctype="multipart/form-data">
    <%-- 这个type="file" 很关键 --%>
    上传头像 : <input type="file" name="filepath" /> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
