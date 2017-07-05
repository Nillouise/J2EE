package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by win7x64 on 2017/7/3.
 */
@WebFilter(filterName = "Flogin",urlPatterns = {"/*"})
public class Flogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        if (uri.endsWith("login.jsp") || uri.endsWith("Clogin")||uri.endsWith("index.jsp")||uri.endsWith("Cindex")||uri.endsWith("register.jsp")||uri.endsWith("Cregister")) {
            chain.doFilter(request, response);
            return;
        }

        String userName = (String) request.getSession().getAttribute("username");
//        if (null == userName) {
//            response.sendRedirect("login.jsp");
//            return;
//        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
