package com.smart4j.chapter03.Action;

import com.smart4j.chapter01.model.Customer;
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
 * @create: 2019-11-30 22:45
 **/
public class EditAction extends Action {
    public EditAction(CustomerService service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("get".equals(reqMethod)){
            long id = Long.parseLong(req.getParameter("id"));
            Customer customer = service.getCustomer(id);
            req.setAttribute("customer",customer);
            req.getRequestDispatcher("/WEB-INF/jsp03/customer_edit.jsp").forward(req,resp);
        }else if ("post".equals(reqMethod)){
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
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/cs03/list");
        }
    }
}
