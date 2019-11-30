package com.smart4j.chapter04.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-30 23:29
 **/
public class View {
    private String path; // jsp的路径
    private Map<String,Object> model; // 数据模型

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public void addModel(String name,Object object) {
        model.put(name,object);
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
