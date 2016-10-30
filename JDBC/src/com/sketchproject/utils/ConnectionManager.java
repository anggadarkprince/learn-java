package com.sketchproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance = null;

    private final String USERNAME = "angga";
    private final String PASSWORD = "angga1234";
    private final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
    private final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

    private DBType dbType = DBType.MYSQL;

    private Connection connection = null;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void setDBType(DBType dbType) {
        this.dbType = dbType;
    }

    private boolean openConnection() {
        try {
            switch (dbType) {

                case MYSQL:
                    connection = DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
                    return true;

                case HSQLDB:
                    connection = DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
                    return true;

                default:
                    return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            if (openConnection()) {
                System.out.println("Connection opened");
                return connection;
            } else {
                return null;
            }
        }
        return connection;
    }

    public void close() {
        System.out.println("Closing connection");
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}