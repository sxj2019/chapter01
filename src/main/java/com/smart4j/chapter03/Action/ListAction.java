package com.smart4j.chapter03.Action;

import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-30 22:34
 **/
public class ListAction extends Action {
    public ListAction(CustomerService service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = this.service.getCustomerList();
        req.setAttribute("customers",customers);
        req.getRequestDispatcher("/WEB-INF/jsp03/customer_list.jsp").forward(req,resp);
    }
}
