import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet",urlPatterns="/login")
public class LoginServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(LoginServlet.class.toString());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);
        logger.trace("name:" + name);
        logger.trace("password:" + password);
        System.out.println("name:" + name);
        System.out.println("password"+password);

    }
}