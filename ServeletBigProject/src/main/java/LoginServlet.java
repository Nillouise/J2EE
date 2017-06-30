import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet",urlPatterns="/login")
public class LoginServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(LoginServlet.class.toString());
    public LoginServlet(){
        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);
        //handnote
        //servlet的生命周期：这里会实例化一个对象来应付所有路由，所以这个构造函数只会被调用一次；
        logger.trace("LoginServlet 构造方法 被调用");
    }

    //handnote
    //servlet的生命周期：这个会在构造对象后调用，大概是被服务器（或者他们的包？）调用
    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //handnote
        //设置中文UTF-8 在request里
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");


        logger.trace("name:" + name);
        logger.trace("password:" + password);

        String html = null;

        if ("admin".equals(name) && "123".equals(password))
        {
            html = "<div style='color:green'>success</div>";
            //handnote
            //Servlet内部的跳转，并不会改变url，login_success.jsp文件对浏览器来说仍然是隐藏的
            request.getRequestDispatcher("login_success.jsp").forward(request,response);

            //也可以发消息到浏览器内让他跳转
            //response.sendRedirect("login_fail.html");

        }
        else
            html = "<div style='color:red'>fail</div>";
        //handnote
        //设置中文UTF-8 在response
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println(html);
    }
}