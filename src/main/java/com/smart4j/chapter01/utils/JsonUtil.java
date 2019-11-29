package com.smart4j.chapter01.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart4j.chapter01.model.Customer;

import java.io.IOException;
import java.util.List;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 21:17
 **/
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String objToJson(List list) {
        try {
            String str = mapper.writeValueAsString(list);
            return str;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void jsonToObj(String json) {
        try {
            Customer customer = mapper.readValue("", Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
