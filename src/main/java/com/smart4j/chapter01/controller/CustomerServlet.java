package com.smart4j.chapter01.controller;

import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter01.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:06
 **/
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private static CommonDao<Customer> commonDao;
    private static CustomerService service;
    static {
        commonDao = new CommonDao<>("customer",Customer.class);
        service = new CustomerService(commonDao);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = commonDao.getEntityList();
//        String json = JsonUtil.objToJson(customers);
        req.setAttribute("customers",customers);
        req.getRequestDispatcher("/WEB-INF/jsp/customer_list.jsp").forward(req,resp);
    }
}
