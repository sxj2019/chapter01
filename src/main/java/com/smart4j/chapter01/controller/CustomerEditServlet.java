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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:07
 **/
@WebServlet("/customer_edit")
public class CustomerEditServlet extends HttpServlet {
    private static CommonDao<Customer> commonDao;
    private static CustomerService service;
    static {
        commonDao = new CommonDao<>("customer",Customer.class);
        service = new CustomerService(commonDao);
    }
    //进入编辑页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Customer customer = service.getCustomer(id);
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/WEB-INF/jsp/customer_edit.jsp").forward(req,resp);
    }

    //保存编辑结果
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> paramNames = req.getParameterNames();
        Map<String,Object> fieldMap = new HashMap<>();
        String key,val;
        while (paramNames.hasMoreElements()){
            key = paramNames.nextElement();
            if (!"id".equals(key)){
                val = req.getParameter(key);
                fieldMap.put(key,val);
            }
        }
        long id = Long.parseLong(req.getParameter("id"));
        service.updateCustomer(id,fieldMap);
        resp.sendRedirect("customer");
    }
}
