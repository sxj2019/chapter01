package com.smart4j.chapter04.Action;

import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter04.pojo.Param;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Action {
    protected String reqMethod;
    protected CustomerService service;

    public Action(CustomerService service) {
        this.service = service;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public abstract Object execute(Param param);
}
