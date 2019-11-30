package com.smart4j.chapter03.Action;

import com.smart4j.chapter01.service.CustomerService;

import javax.servlet.ServletException;
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
 * @create: 2019-11-30 22:41
 **/
public class AddAction extends Action {
    public AddAction(CustomerService service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("get".equals(reqMethod)){
            req.getRequestDispatcher("/WEB-INF/jsp03/customer_add.jsp").forward(req,resp);
        }else if ("post".equals(reqMethod)){
            Enumeration<String> paramNames = req.getParameterNames();
            Map<String,Object> fieldMap = new HashMap<>();
            String key,val;
            while (paramNames.hasMoreElements()){
                key = paramNames.nextElement();
                val = req.getParameter(key);
                fieldMap.put(key,val);
            }
            service.createCustomer(fieldMap);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/cs03/list");
        }
    }
}
