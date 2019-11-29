package com.smart4j.chapter01.controller;

import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: chapter01
 * @description: 删除客户
 * @author: sxj
 * @create: 2019-11-28 15:07
 **/
@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {
    private static CommonDao<Customer> commonDao;
    private static CustomerService service;
    static {
        commonDao = new CommonDao<>("customer",Customer.class);
        service = new CustomerService(commonDao);
    }
    //删除
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean isDel = service.deleteCustomer(Long.parseLong(id));
        resp.sendRedirect("customer");
    }
}
