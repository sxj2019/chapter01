package com.smart4j.chapter03.Action;

import com.smart4j.chapter01.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-30 22:46
 **/
public class DeleteAction extends Action {
    public DeleteAction(CustomerService service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean isDel = service.deleteCustomer(Long.parseLong(id));
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/cs03/list");
    }
}
