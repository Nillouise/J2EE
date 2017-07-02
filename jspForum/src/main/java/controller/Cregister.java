package controller;

import Model.ConnectionPool;
import Model.Muserinfo;
import Model.MuserinfoDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.sql.Connection;

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
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        Muserinfo userinfo= new Muserinfo();
        userinfo.UserName = request.getParameter("username");
        userinfo.Password = request.getParameter("password");
        new MuserinfoDAO(connpool.getConnection()).add(userinfo);


    }


}
