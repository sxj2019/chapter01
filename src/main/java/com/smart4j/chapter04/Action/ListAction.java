package com.smart4j.chapter04.Action;

import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter04.pojo.Param;
import com.smart4j.chapter04.pojo.View;

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
    public Object execute(Param param) {
        List<Customer> customers = this.service.getCustomerList();
        View view = new View("customer_list");
        view.addModel("customers",customers);
        return view;
    }
}
