package com.smart4j.chapter04.pojo;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-30 23:28
 **/
public class Param {

    private HttpServletRequest req;

    public Param(HttpServletRequest req) {
        this.req = req;
    }

    public long getLong() {
        String id = req.getParameter("id");
        return Long.parseLong(id);
    }

    public Map<String,Object> getFieldMap(){
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
        return fieldMap;
    }
}
