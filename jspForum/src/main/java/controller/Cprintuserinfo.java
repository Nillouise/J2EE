package controller;

import Model.ConnectionPool;
import Model.Muserinfo;
import Model.MuserinfoDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by win7x64 on 2017/7/2.
 */
@WebServlet(name = "Cprintuserinfo",urlPatterns = {"/printuserinfo"})
public class Cprintuserinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        List<Muserinfo> list =  new MuserinfoDAO(ConnectionPool.getPool().getConnection()).list();

        request.setAttribute("userinfolist", list);
        request.getRequestDispatcher("printuserinfo.jsp").forward(request,response);
    }

}
