package com.smart4j.chapter01.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:33
 **/
public class DbHelper {
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    static {
        Properties props = PropsUtil.loadProperties("db.properties");
        DRIVER = props.getProperty("jdbc.driver");
        URL = props.getProperty("jdbc.url");
        USERNAME = props.getProperty("jdbc.username");
        PASSWORD = props.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
