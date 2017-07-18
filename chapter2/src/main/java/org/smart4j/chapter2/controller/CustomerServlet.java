package org.smart4j.chapter2.controller;

import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by win7x64 on 2017/7/18.
 */
@WebServlet(name = "CustomerServlet",urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    public void init() throws ServletException
    {
        super.init();
        customerService = new CustomerService();

    }

    private CustomerService customerService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Customer> customerList = customerService.getCustomerList();
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("customer.jsp").forward(request,response);

    }
}
