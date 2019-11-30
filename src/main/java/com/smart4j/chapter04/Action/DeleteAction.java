package com.smart4j.chapter04.Action;

import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter04.pojo.Param;
import com.smart4j.chapter04.pojo.View;

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
    public Object execute(Param param) {
        long id = param.getLong();
        service.deleteCustomer(id);
        return new View("/list");
    }
}
