<%-- handnote 包含这个页面的会送一个完整的request过来的 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<p style="text-align:center">
    top bar
<%
        String username = (String)(request.getSession().getAttribute("username"));
        if(username!=null)
        {
            out.println(username);
        }else{
%>
    <a href='/login.jsp'> 登录 </a>
    <a href='/register.jsp'> 注册 </a>
    <%
        }
%>


</p>

