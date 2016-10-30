package com.sketchproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC
 * Created by Angga on 29/07/2016.
 */
public class DBUtil {
    private static final String USERNAME = "angga";
    private static final String PASSWORD = "angga1234";
    private static final String HSQL_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
    private static final String MYSQL_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException {

        switch (dbType) {
            case HSQLDB:
                return DriverManager.getConnection(HSQL_CONN_STRING, USERNAME, PASSWORD);
            case MYSQL:
                return DriverManager.getConnection(MYSQL_CONN_STRING, USERNAME, PASSWORD);

            default:
                throw new AssertionError();
        }
    }

    public static void processException(SQLException e){
        System.out.println("Error message : " + e.getMessage());
        System.out.println("Error code : " + e.getErrorCode());
        System.out.println("SQL state : " + e.getSQLState());
    }
}
