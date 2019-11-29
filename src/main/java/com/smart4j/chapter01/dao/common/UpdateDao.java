package com.smart4j.chapter01.dao.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 19:18
 **/
public class UpdateDao<T> extends AbstractDao {
    @Override
    protected Object executeQuery(PreparedStatement stat, Class claz) throws SQLException, IllegalAccessException, InstantiationException {
        return stat.executeUpdate();
    }
}
