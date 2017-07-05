//handout http 500 错误，貌似是因为包名冲突，就是说，这个有两个目录的包名相同，这样不行（大小写不敏感）
package Controller2;

import Model2.ConnectionPool;
import Model2.Product;
import Model2.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by win7x64 on 2017/7/4.
 */


@WebServlet(name = "productShow",urlPatterns = {"/chart/productShow"})
public class productShow extends HttpServlet
{

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Product> pl =  new ProductDAO(ConnectionPool.getPool().getConnection()).get();

        HttpSession session =  request.getSession();
        session.setAttribute("productlist",pl);
        request.getRequestDispatcher("/chart/productShow.jsp").forward(request,response);
    }
}
