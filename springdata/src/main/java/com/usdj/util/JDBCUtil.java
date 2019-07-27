package com.usdj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author gerrydeng
 * @date 2019-07-25 09:50
 * @Description: JDBCUtil
 */
public class JDBCUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");
        Class.forName(driverClass);
        return DriverManager.getConnection(url, user, password);

    }

    /**
     * 释放DB资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet,
                               Statement statement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
