package com.smart4j.chapter01.utils;

import java.lang.reflect.Field;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 16:04
 **/
public class ClassUtil {

    public static String commonToString(Class clz,Object obj) {
        StringBuffer sb = new StringBuffer(clz.getSimpleName());
        sb.append("[");
        Field[] fields = clz.getDeclaredFields();
        for (Field fd : fields){
            fd.setAccessible(true);
            String name = fd.getName();
            Object val = null;
            try {
                val = fd.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append(name);
            sb.append("=");
            sb.append(val);
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
