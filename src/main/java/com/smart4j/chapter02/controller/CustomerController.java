package com.smart4j.chapter02.controller;

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
import java.util.List;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-29 17:48
 **/
@WebServlet("/cs")
public class CustomerController extends HttpServlet {

    private static CommonDao<Customer> commonDao;
    private static CustomerService service;
    static {
        commonDao = new CommonDao<>("customer",Customer.class);
        service = new CustomerService(commonDao);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            getList(req,resp);
        }else if ("toAdd".equals(action)){
            toAdd(req,resp);
        }else if ("addData".equals(action)){
            addData(req,resp);
        }else if ("delData".equals(action)){
            delData(req,resp);
        }else if ("toEdit".equals(action)){
            toEdit(req,resp);
        }else if ("editData".equals(action)){
            editData(req,resp);
        }

    }

    //1, get,跳到列表页面
    public void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = commonDao.getEntityList();
        req.setAttribute("customers",customers);
        req.getRequestDispatcher("/WEB-INF/jsp02/customer_list.jsp").forward(req,resp);
    }

    //2,get  跳转到add页面
    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp02/customer_add.jsp").forward(req,resp);
    }
    //3 post 携带数据，保存后跳到列表
    public void addData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> paramNames = req.getParameterNames();
        Map<String,Object> fieldMap = new HashMap<>();
        String key,val;
        while (paramNames.hasMoreElements()){
            key = paramNames.nextElement();
            if (!"action".equals(key)){
                val = req.getParameter(key);
                fieldMap.put(key,val);
            }
        }
        service.createCustomer(fieldMap);
        resp.sendRedirect("cs");
    }

    //4 get 跳到edit页面
    public void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Customer customer = service.getCustomer(id);
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/WEB-INF/jsp02/customer_edit.jsp").forward(req,resp);
    }
    //5 post 携带数据，保存后，跳到列表页面
    public void editData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> paramNames = req.getParameterNames();
        Map<String,Object> fieldMap = new HashMap<>();
        String key,val;
        while (paramNames.hasMoreElements()){
            key = paramNames.nextElement();
            if (!"id".equals(key) && !"action".equals(key)){
                val = req.getParameter(key);
                fieldMap.put(key,val);
            }
        }
        long id = Long.parseLong(req.getParameter("id"));
        service.updateCustomer(id,fieldMap);
        resp.sendRedirect("cs");
    }
    //6 get ,删除数据后，跳到列表页面
    public void delData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean isDel = service.deleteCustomer(Long.parseLong(id));
        resp.sendRedirect("cs");
    }
}
