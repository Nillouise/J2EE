package Controller2;

import Model2.Order;

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


@WebServlet(name = "addChart",urlPatterns = {"/chart/addChart"})
public class addChart extends HttpServlet
{

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();


        int productid = Integer.parseInt( request.getParameter("productid"));
        List<Order> list = (List<Order>)session.getAttribute("OrderItem");
        int ok=0;
        for(Order i: list)
        {
            if(i.getProductid() == productid)
            {
                i.setQuantity(i.getQuantity()+1);
                ok = 1;
                break;
            }
        }
        if(ok==0)
        {
            Order oder = new Order();
            oder.setId(list.size());
            oder.setQuantity(1);
            oder.setProductid(productid);
            oder.setUserid((int) session.getAttribute("userid"));
            list.add(oder);
        }
        request.getRequestDispatcher("chart/chart.jsp").forward(request,response);

    }
}
