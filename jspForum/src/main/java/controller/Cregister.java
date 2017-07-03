package controller;

import Model.ConnectionPool;
import Model.Muserinfo;
import Model.MuserinfoDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by win7x64 on 2017/7/2.
 */
@javax.servlet.annotation.WebServlet(name = "Cregister",urlPatterns = {"/Cregister"})
public class Cregister extends javax.servlet.http.HttpServlet
{
    ConnectionPool connpool;
    public Cregister()
    {
        super();
        connpool = ConnectionPool.getPool();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Muserinfo userinfo= new Muserinfo();
        userinfo.username = request.getParameter("username");
        userinfo.password = request.getParameter("password");
        new MuserinfoDAO(connpool.getConnection()).add(userinfo);

        HttpSession session =  request.getSession();
        session.setAttribute("username",userinfo.username);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }


}
