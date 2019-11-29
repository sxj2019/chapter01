package com.smart4j.chapter01.dao.common;

import com.smart4j.chapter01.utils.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 19:16
 **/
public abstract class AbstractDao {
    public Object execute(Class claz,String sql, Object... params) {
        //1,获取连接
        Connection conn = DbHelper.getConnection();
        //2，执行预处理
        PreparedStatement stat =null;
        try {
            stat = conn.prepareStatement(sql);
            //3，给参数赋值
            if (params != null){
                for (int i = 0; i < params.length; i++) {
                    stat.setObject(i+1,params[i]);
                }
            }
            //执行sql,返回执行结果
            return executeQuery(stat,claz);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            //6,关闭连接
            DbHelper.close(conn);
        }
        return null;
    }

    protected abstract Object executeQuery(PreparedStatement stat,Class claz) throws SQLException, IllegalAccessException, InstantiationException;
}
