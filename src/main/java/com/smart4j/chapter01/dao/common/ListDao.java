package com.smart4j.chapter01.dao.common;

import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.utils.DbHelper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 19:00
 **/
public class ListDao<T> extends AbstractDao{
    protected Object executeQuery(PreparedStatement stat,Class claz) throws SQLException, IllegalAccessException, InstantiationException {
        List<T> lst = new ArrayList<>();
        //4，执行查询
        ResultSet retSet = stat.executeQuery();
        //5，迭代获取结果
        while (retSet.next()){
            Object o = claz.newInstance();
            Field[] fields = claz.getDeclaredFields();
            for (Field fd : fields){
                fd.setAccessible(true);
                String fdName = fd.getName();
                fd.set(o,retSet.getObject(fdName));
            }
            lst.add((T) o);
        }
        return lst;
    }


}
