package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win7x64 on 2017/7/3.
 */
@WebFilter(filterName = "Fsetencoding",urlPatterns = {"/*"})
public class Fsetencoding implements Filter
{
    public void destroy()
    {
    }
//handnote 在Filter里一劳永逸地解决中文字符编码问题，Encoding
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
  //一个类内只能chain.doFilter一次，
        //      chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException
    {

    }

}
