package com.smart4j.chapter01.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:28
 **/
public class PropsUtil {

    public static Properties loadProperties(String fileName) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }
}
