package controller;

import Model2.ConnectionPool;
import Model2.Muserinfo;
import Model2.MuserinfoDAO;

import javax.servlet.ServletException;
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

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        MuserinfoDAO muserinfo   =  new MuserinfoDAO(ConnectionPool.getPool().getConnection());
        List<Muserinfo> list  = muserinfo.list();
        request.setAttribute("userinfolist", list);
        request.setAttribute("muserinfo_getCount",muserinfo.getCount());
        request.setAttribute("test","testans");
        request.getRequestDispatcher("printuserinfo.jsp").forward(request,response);
    }

}
