package controller;

import Model.ConnectionPool;
import Model.Muserinfo;
import Model.MuserinfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by win7x64 on 2017/7/3.
 */
@WebServlet(name = "Clogin",urlPatterns = {"/Clogin"})
public class Clogin extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isOk = new MuserinfoDAO(ConnectionPool.getPool().getConnection()).get(user,password);
        if(isOk)
        {
            HttpSession session = request.getSession();
            session.setAttribute("username",request.getParameter("username") );
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            response.getWriter().println("login false");
        }
    }
}
