package com.smart4j.chapter03.Controller;

import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter03.Action.Action;
import com.smart4j.chapter03.Action.ActionFactory;

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
 * @create: 2019-11-30 22:16
 **/
@WebServlet(urlPatterns = "/cs03/*")
public class CustomerController extends HttpServlet {

    protected ActionFactory factory = new ActionFactory();


    //获取Action的名称
    protected String getReqUrl(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        return pathInfo.substring(1);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMethod = req.getMethod().toLowerCase();
        String reqUrl = getReqUrl(req);
        Action action = factory.create(reqMethod, reqUrl);
        action.execute(req,resp);
    }

}
