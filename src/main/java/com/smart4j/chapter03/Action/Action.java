package com.smart4j.chapter03.Action;

import com.smart4j.chapter01.service.CustomerService;

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

    public abstract void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }
}
