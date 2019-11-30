package com.smart4j.chapter04.Action;

import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter04.pojo.Param;
import com.smart4j.chapter04.pojo.View;

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
    public Object execute(Param param) {
        if ("get".equals(reqMethod)){
            return new View("customer_add");
        }else if ("post".equals(reqMethod)){
            Map<String,Object> fieldMap = param.getFieldMap();
            service.createCustomer(fieldMap);
            return new View("/list");
        }
        return null;
    }
}
