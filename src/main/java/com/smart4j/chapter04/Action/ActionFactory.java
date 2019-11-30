package com.smart4j.chapter04.Action;

import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-30 22:24
 **/
public class ActionFactory {
    private static CommonDao<Customer> commonDao;
    private static CustomerService service;
    static {
        commonDao = new CommonDao<>("customer",Customer.class);
        service = new CustomerService(commonDao);
    }
    private static final Map<String,Action> actionMap;
    static {
        actionMap = new HashMap<>();
        actionMap.put("list",new ListAction(service));
        actionMap.put("toAdd",new AddAction(service));
        actionMap.put("toEdit",new EditAction(service));
        actionMap.put("toDel",new DeleteAction(service));
    }
    public Action create(String reqMethod,String reqUrl) {
        Action action = actionMap.get(reqUrl);
        action.setReqMethod(reqMethod);
        return action;
    }
}
