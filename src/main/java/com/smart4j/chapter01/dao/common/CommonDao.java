package com.smart4j.chapter01.dao.common;

import com.smart4j.chapter01.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 16:32
 **/
public class CommonDao<T> {
    private String tableName;
    private ListDao<T> listDao;
    private UpdateDao<T> updateDao;
    private Class claz;

    public CommonDao(String tableName, Class claz) {
        this.tableName = tableName;
        this.claz = claz;
        listDao = new ListDao<>();
        updateDao = new UpdateDao<>();
    }

    public List<T> getEntityList(Object... params) {
        String sql = "select * from " + this.tableName;
        if (params!=null && params.length == 1){
            sql += " where id=?";
        }
        List<T> customers = (List<T>) listDao.execute(claz,sql, params);
        return customers;
    }

    public boolean addEntity(Map<String,Object> fieldMap) {
        //组装sql
        StringBuffer key = new StringBuffer("insert into ");
        StringBuffer val = new StringBuffer("values(");
        key.append(this.tableName);
        key.append("(");
        fieldMap.forEach((s, o) -> {
            key.append(s);
            key.append(",");
            val.append("?,");
        });
        key.deleteCharAt(key.lastIndexOf(","));
        val.deleteCharAt(val.lastIndexOf(","));
        key.append(")");
        val.append(")");
        String sql = key.append(val).toString();
//        System.out.println("sql: "+sql);
        Object[] params = fieldMap.values().toArray();
        int rowNum = (int) updateDao.execute(Customer.class,sql,params);
        return rowNum > 0;
    }

    public boolean updateEntity(long id,Map<String,Object> fieldMap) {
        StringBuffer sb = new StringBuffer("update ");
        sb.append(this.tableName);
        sb.append(" set ");
        fieldMap.forEach((s, o) -> {
            sb.append(s);
            sb.append("=?,");
        });
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" where id =");
        sb.append(id);
        String sql = sb.toString();
//        System.out.println("sql: "+sql);
        Object[] params = fieldMap.values().toArray();
        int rowNum = (int) updateDao.execute(Customer.class,sql,params);
        return rowNum > 0;
    }

    public boolean deleteEntity(long id) {
        String sql = "delete from "+this.tableName+" where id = ?";
        int rowNum = (int) updateDao.execute(Customer.class,sql,id);
        return rowNum > 0;
    }

}
