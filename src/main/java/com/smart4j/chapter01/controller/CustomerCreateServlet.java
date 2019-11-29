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
 * @description: 创建客户
 * @author: sxj
 * @create: 2019-11-28 15:07
 **/
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet {
    private static CommonDao<Customer> commonDao;
    private static CustomerService service;
    static {
        commonDao = new CommonDao<>("customer",Customer.class);
        service = new CustomerService(commonDao);
    }

    //进入创建客户的页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/customer_add.jsp").forward(req,resp);
    }

    //创建客户
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> paramNames = req.getParameterNames();
        Map<String,Object> fieldMap = new HashMap<>();
        String key,val;
        while (paramNames.hasMoreElements()){
            key = paramNames.nextElement();
            val = req.getParameter(key);
            fieldMap.put(key,val);
        }
        service.createCustomer(fieldMap);
        resp.sendRedirect("customer");
    }
}
